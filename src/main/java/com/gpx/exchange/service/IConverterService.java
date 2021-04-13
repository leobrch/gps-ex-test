package com.gpx.exchange.service;

import com.gpx.exchange.domain.GPS;
import com.gpx.exchange.domain.Link;
import com.gpx.exchange.domain.Metadata;
import com.gpx.exchange.domain.Track;
import com.gpx.exchange.domain.TrackSegment;
import com.gpx.exchange.domain.Waypoint;
import com.gpx.exchange.domain.jaxb2.LinkType;
import com.gpx.exchange.domain.jaxb2.MetadataType;
import com.gpx.exchange.domain.jaxb2.TrkType;
import com.gpx.exchange.domain.jaxb2.TrksegType;
import com.gpx.exchange.domain.jaxb2.WptType;
import com.gpx.exchange.dto.GPSDTO;
import com.gpx.exchange.dto.LinkDTO;
import com.gpx.exchange.dto.MetadataDTO;

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
