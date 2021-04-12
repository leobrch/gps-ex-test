package com.example.demo.service;

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

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

public interface IConverterService {
    Metadata convertMetadata(MetadataType metadataType);

    Link convertLink(LinkType linkType);

    Track convertTrack(TrkType trkType);

    TrackSegment convertTrackSegment(TrksegType trksegType);

    Waypoint convertWaypoint(WptType wptType);

    LocalDateTime convertLocalDateTime(XMLGregorianCalendar calendar);
}
