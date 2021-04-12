package com.example.demo.service.impl;

import com.example.demo.constant.status.AppStatus;
import com.example.demo.constant.status.StatusFactory;
import com.example.demo.domain.GPS;
import com.example.demo.domain.Track;
import com.example.demo.domain.Waypoint;
import com.example.demo.domain.jaxb2.GpxType;
import com.example.demo.domain.jaxb2.MetadataType;
import com.example.demo.domain.jaxb2.TrkType;
import com.example.demo.domain.jaxb2.WptType;
import com.example.demo.repository.GPSRepository;
import com.example.demo.service.IConverterService;
import com.example.demo.service.IGPSService;
import com.example.demo.service.IService;
import com.example.demo.service.IXMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPSService implements IGPSService, IService<GPS> {

    @Autowired
    private IXMLConverter xmlConverter;

    @Autowired
    private IConverterService converterService;

    @Autowired
    private GPSRepository gpsRepository;

    @Override
    public AppStatus getLatestTrack() {
        return null;
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
            gps.setMetadata(converterService.convertMetadata(metadataType));
        }

        List<WptType> wptTypes = gpxType.getWpt();
        if (!CollectionUtils.isEmpty(wptTypes)) {
            List<Waypoint> waypoints = wptTypes.stream()
                    .map(wptType -> converterService.convertWaypoint(wptType))
                    .collect(Collectors.toList());
            gps.setWpt(waypoints);
        }

        List<TrkType> trkTypes = gpxType.getTrk();
        if (!CollectionUtils.isEmpty(trkTypes)) {
            List<Track> tracks = trkTypes.stream()
                    .map(trkType -> converterService.convertTrack(trkType))
                    .collect(Collectors.toList());
            gps.setTrk(tracks);
        }

        return StatusFactory.ofOk(gps);
    }

    @Override
    public AppStatus getGPXDetailByUserId(Long id) {
        return null;
    }

    @Override
    public void create(GPS gps) {
        gpsRepository.save(gps);
    }

    @Override
    public void update(GPS gps) {

    }

    @Override
    public void delete(Long id) {

    }
}
