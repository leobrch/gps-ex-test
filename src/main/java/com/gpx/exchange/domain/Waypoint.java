package com.gpx.exchange.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "waypoint")
public class Waypoint extends AbstractEntity {

    @Column(name = "ele")
    private BigDecimal ele;

    @Column(name = "time")
    private Date time;

    @Column(name = "name")
    private String name;

    @Column(name = "sym")
    private String sym;

    @Column(name = "lat")
    private BigDecimal lat;

    @Column(name = "lon")
    private BigDecimal lon;

    @ManyToOne
    @JoinColumn(name = "gps_id")
    @JsonBackReference
    private GPS gpsWpt;

    @ManyToOne
    @JoinColumn(name = "trk_seg_id")
    @JsonBackReference
    private TrackSegment trkSeg;

    public Waypoint() {
    }

    public Waypoint(BigDecimal ele, Date time, String name, String sym, BigDecimal lat, BigDecimal lon) {
        this.ele = ele;
        this.time = time;
        this.name = name;
        this.sym = sym;
        this.lat = lat;
        this.lon = lon;
    }

    public Waypoint(BigDecimal ele, Date time, String name, String sym, BigDecimal lat, BigDecimal lon, GPS gpsWpt) {
        this.ele = ele;
        this.time = time;
        this.name = name;
        this.sym = sym;
        this.lat = lat;
        this.lon = lon;
        this.gpsWpt = gpsWpt;
    }

    public Waypoint(BigDecimal ele, Date time, String name, String sym, BigDecimal lat, BigDecimal lon, TrackSegment trkSeg) {
        this.ele = ele;
        this.time = time;
        this.name = name;
        this.sym = sym;
        this.lat = lat;
        this.lon = lon;
        this.trkSeg = trkSeg;
    }

    public BigDecimal getEle() {
        return ele;
    }

    public void setEle(BigDecimal ele) {
        this.ele = ele;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSym() {
        return sym;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public GPS getGpsWpt() {
        return gpsWpt;
    }

    public void setGpsWpt(GPS gpsWpt) {
        this.gpsWpt = gpsWpt;
    }

    public TrackSegment getTrkSeg() {
        return trkSeg;
    }

    public void setTrkSeg(TrackSegment trkSeg) {
        this.trkSeg = trkSeg;
    }
}
