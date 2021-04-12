package com.example.demo.service.impl;

import com.example.demo.domain.GPS;
import com.example.demo.domain.Link;
import com.example.demo.domain.Metadata;
import com.example.demo.domain.Track;
import com.example.demo.domain.TrackSegment;
import com.example.demo.domain.Waypoint;
import com.example.demo.domain.jaxb2.LinkType;
import com.example.demo.domain.jaxb2.MetadataType;
import com.example.demo.domain.jaxb2.TrkType;
import com.example.demo.domain.jaxb2.TrksegType;
import com.example.demo.domain.jaxb2.WptType;
import com.example.demo.dto.GPSDTO;
import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.MetadataDTO;
import com.example.demo.service.IConverterService;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ConverterService implements IConverterService {
    @Override
    public Metadata convertMetadata(MetadataType metadataType) {
        Metadata metadata = new Metadata();
        metadata.setName(metadataType.getName());
        metadata.setDesc(metadataType.getDesc());
        metadata.setAuthor(metadataType.getAuthor().getName());
        metadata.setLink(metadataType.getLink().stream().map(this::convertLink).collect(Collectors.toList()));
        metadata.setTime(convertTime(metadataType.getTime()));
        return metadata;
    }

    @Override
    public Link convertLink(LinkType linkType) {
        return new Link(linkType.getText(), linkType.getType(), linkType.getHref());
    }

    @Override
    public Track convertTrack(TrkType trkType, GPS gps) {
        return new Track(trkType.getName(), trkType.getDesc(),
                trkType.getLink().stream().map(this::convertLink).collect(Collectors.toList()),
                trkType.getTrkseg().stream().map(this::convertTrackSegment).collect(Collectors.toList()), gps);
    }

    @Override
    public TrackSegment convertTrackSegment(TrksegType trksegType) {
        return new TrackSegment(trksegType.getTrkpt().stream().map(this::convertWaypoint).collect(Collectors.toList()));
    }

    @Override
    public Waypoint convertWaypointWithGPS(WptType wptType, GPS gps) {
        return new Waypoint(wptType.getEle(), convertTime(wptType.getTime()), wptType.getName(),
                wptType.getSym(), wptType.getLat(), wptType.getLon(), gps);
    }

    @Override
    public Waypoint convertWaypointWithTrackSegment(WptType wptType, TrackSegment trackSegment) {
        return new Waypoint(wptType.getEle(), convertTime(wptType.getTime()), wptType.getName(),
                wptType.getSym(), wptType.getLat(), wptType.getLon(), trackSegment);
    }

    @Override
    public Waypoint convertWaypoint(WptType wptType) {
        return new Waypoint(wptType.getEle(), convertTime(wptType.getTime()), wptType.getName(),
                wptType.getSym(), wptType.getLat(), wptType.getLon());
    }

    @Override
    public Date convertTime(XMLGregorianCalendar calendar) {
        return calendar == null ? null : calendar.toGregorianCalendar().getTime();
    }

    @Override
    public GPSDTO convertToGPSDTO(GPS gps) {
        return new GPSDTO(gps.getId(), convertToMetadataDTO(gps.getMetadata()), gps.getCreatedDate(), gps.getUpdatedDate());
    }

    @Override
    public MetadataDTO convertToMetadataDTO(Metadata metadata) {
        return metadata != null ? new MetadataDTO(metadata.getName(), metadata.getDesc(),
                metadata.getAuthor(), metadata.getLink().stream().map(this::convertToLinkDTO).collect(Collectors.toList()),
                metadata.getTime()) : null;
    }

    @Override
    public LinkDTO convertToLinkDTO(Link link) {
        return link != null ? new LinkDTO(link.getText(), link.getType(), link.getHref()) : null;
    }
}
