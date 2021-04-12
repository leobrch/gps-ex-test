package com.example.demo.service;

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

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

public interface IConverterService {
    Metadata convertMetadata(MetadataType metadataType);

    Link convertLink(LinkType linkType);

    Track convertTrack(TrkType trkType, GPS gps);

    TrackSegment convertTrackSegment(TrksegType trksegType);

    Waypoint convertWaypointWithGPS(WptType wptType, GPS gps);

    Waypoint convertWaypointWithTrackSegment(WptType wptType, TrackSegment trackSegment);

    Waypoint convertWaypoint(WptType wptType);

    Date convertTime(XMLGregorianCalendar calendar);

    GPSDTO convertToGPSDTO(GPS gps);

    MetadataDTO convertToMetadataDTO(Metadata metadata);

    LinkDTO convertToLinkDTO(Link link);
}
