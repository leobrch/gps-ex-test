package com.example.demo.service.impl;

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
import com.example.demo.service.IConverterService;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
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
        metadata.setTime(convertLocalDateTime(metadataType.getTime()));
        return metadata;
    }

    @Override
    public Link convertLink(LinkType linkType) {
        return new Link(linkType.getText(), linkType.getType(), linkType.getHref());
    }

    @Override
    public Track convertTrack(TrkType trkType) {
        return new Track(trkType.getName(), trkType.getDesc(),
                trkType.getLink().stream().map(this::convertLink).collect(Collectors.toList()),
                trkType.getTrkseg().stream().map(this::convertTrackSegment).collect(Collectors.toList()));
    }

    @Override
    public TrackSegment convertTrackSegment(TrksegType trksegType) {
        return new TrackSegment(trksegType.getTrkpt().stream().map(this::convertWaypoint).collect(Collectors.toList()));
    }

    @Override
    public Waypoint convertWaypoint(WptType wptType) {
        return new Waypoint(wptType.getEle(),
                convertLocalDateTime(wptType.getTime()), wptType.getName(),
                wptType.getSym(), wptType.getLat(), wptType.getLon());
    }

    @Override
    public LocalDateTime convertLocalDateTime(XMLGregorianCalendar calendar) {
        return LocalDateTime.of(calendar.getYear(), calendar.getMonth(), calendar.getDay(),
                calendar.getHour(), calendar.getMinute(), calendar.getSecond());
    }
}
