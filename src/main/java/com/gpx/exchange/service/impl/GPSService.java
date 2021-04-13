package com.gpx.exchange.service.impl;

import com.gpx.exchange.constant.status.AppStatus;
import com.gpx.exchange.constant.status.StatusFactory;
import com.gpx.exchange.domain.GPS;
import com.gpx.exchange.domain.Link;
import com.gpx.exchange.domain.Track;
import com.gpx.exchange.domain.TrackSegment;
import com.gpx.exchange.domain.Waypoint;
import com.gpx.exchange.domain.jaxb2.GpxType;
import com.gpx.exchange.domain.jaxb2.MetadataType;
import com.gpx.exchange.domain.jaxb2.TrkType;
import com.gpx.exchange.domain.jaxb2.WptType;
import com.gpx.exchange.repository.GPSRepository;
import com.gpx.exchange.service.IConverterService;
import com.gpx.exchange.service.IGPSService;
import com.gpx.exchange.service.ILinkService;
import com.gpx.exchange.service.IMetadataService;
import com.gpx.exchange.service.ITrackSegmentService;
import com.gpx.exchange.service.ITrackService;
import com.gpx.exchange.service.IWaypointService;
import com.gpx.exchange.service.IXMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPSService implements IGPSService {

    @Autowired
    private IXMLConverter xmlConverter;

    @Autowired
    private IConverterService converterService;

    @Autowired
    private IMetadataService metadataService;

    @Autowired
    private ITrackService trackService;

    @Autowired
    private IWaypointService waypointService;

    @Autowired
    private ILinkService linkService;

    @Autowired
    private ITrackSegmentService trackSegmentService;

    @Autowired
    private GPSRepository gpsRepository;

    @Override
    public AppStatus getLatestTrack(int pageNumber, int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize);
        return StatusFactory.ofOk(gpsRepository.findAll(pageRequest)
                .map(source -> converterService.convertToGPSDTO(source)));
    }

    @Override
    public AppStatus uploadFile(MultipartFile file) {
        GpxType gpxType = xmlConverter.unmarshall(file);

        if (gpxType == null) {
            return StatusFactory.ofInternalError(null);
        }

        GPS gps = new GPS();

        MetadataType metadataType = gpxType.getMetadata();
        if (metadataType != null) {
            gps.setMetadata(metadataService.create(converterService.convertMetadata(metadataType)));
        }

        GPS gpsCreated = gpsRepository.save(gps);

        List<WptType> wptTypes = gpxType.getWpt();
        if (!CollectionUtils.isEmpty(wptTypes)) {
            List<Waypoint> waypoints = wptTypes.stream()
                    .map(wptType -> converterService.convertWaypointWithGPS(wptType, gpsCreated))
                    .collect(Collectors.toList());
            waypointService.bulkCreate(waypoints);
            gps.setWpt(waypoints);
        }

        List<TrkType> trkTypes = gpxType.getTrk();
        if (!CollectionUtils.isEmpty(trkTypes)) {
            // bulk create track
            List<Track> tracks = trkTypes.stream()
                    .map(trkType -> converterService.convertTrack(trkType, gpsCreated))
                    .collect(Collectors.toList());
            List<Track> trackCreated = trackService.bulkCreate(tracks);

            // bulk create track link
            List<Link> trackLinks = trackCreated.stream()
                    .flatMap(track -> track.getLink().stream().peek(link -> link.setTrkLink(track)))
                    .collect(Collectors.toList());
            linkService.bulkCreate(trackLinks);
            // bulk create track segment
            List<TrackSegment> trackSegments = trackCreated.stream()
                    .flatMap(track -> track.getTrkSeg().stream().peek(trackSegment -> trackSegment.setTrkSeg(track)))
                    .collect(Collectors.toList());
            List<TrackSegment> trackSegmentCreated = trackSegmentService.bulkCreate(trackSegments);
            // bulk create track point
            List<Waypoint> trackPoints = trackSegmentCreated.stream()
                    .flatMap(trackSegment -> trackSegment.getTrkpt().stream()
                            .peek(waypoint -> waypoint.setTrkSeg(trackSegment)))
                    .collect(Collectors.toList());
            waypointService.bulkCreate(trackPoints);
            gps.setTrk(trackCreated);
        }
        return StatusFactory.ofOk(gpsCreated);
    }

    @Override
    public AppStatus getGPXDetailByGPSId(Long id) {
        GPS gps = gpsRepository.findOne(id);
        if (gps == null) {
            return StatusFactory.ofNotFound();
        }
        return StatusFactory.ofOk(gps);
    }

    @Transactional
    @Override
    public GPS create(GPS gps) {
        return gpsRepository.save(gps);
    }

    @Override
    public List<GPS> bulkCreate(List<GPS> gps) {
        return gpsRepository.save(gps);
    }
}
