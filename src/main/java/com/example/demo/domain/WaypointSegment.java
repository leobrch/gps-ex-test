package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "waypoint")
public class WaypointSegment extends AbstractEntity {

    @Column(name = "ele")
    private BigDecimal ele;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "name")
    private String name;

    @Column(name = "sym")
    private String sym;

    @Column(name = "lat")
    private BigDecimal lat;

    @Column(name = "lon")
    private BigDecimal lon;

    @ManyToOne
    @JoinColumn(name="trk_seg_id", nullable=false)
    private TrackSegment trkSeg;

    public BigDecimal getEle() {
        return ele;
    }

    public void setEle(BigDecimal ele) {
        this.ele = ele;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    public TrackSegment getTrkSeg() {
        return trkSeg;
    }

    public void setTrkSeg(TrackSegment trkSeg) {
        this.trkSeg = trkSeg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaypointSegment that = (WaypointSegment) o;
        return Objects.equals(ele, that.ele) && Objects.equals(time, that.time) && Objects.equals(name, that.name) && Objects.equals(sym, that.sym) && Objects.equals(lat, that.lat) && Objects.equals(lon, that.lon) && Objects.equals(trkSeg, that.trkSeg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ele, time, name, sym, lat, lon, trkSeg);
    }
}
