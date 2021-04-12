package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "track")
public class Track extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "desc", length = 1000)
    private String desc;

    @OneToMany(mappedBy = "trkLink", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Link> link;

    @OneToMany(mappedBy = "trkSeg", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<TrackSegment> trkSeg;

    @ManyToOne
    @JoinColumn(name = "gps_id")
    @JsonBackReference
    private GPS gpsTrk;

    public Track() {
    }

    public Track(String name, String desc, List<Link> link, List<TrackSegment> trkSeg) {
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.trkSeg = trkSeg;
    }

    public Track(String name, String desc, List<Link> link, List<TrackSegment> trkSeg, GPS gpsTrk) {
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.trkSeg = trkSeg;
        this.gpsTrk = gpsTrk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public List<TrackSegment> getTrkSeg() {
        return trkSeg;
    }

    public void setTrkSeg(List<TrackSegment> trkSeg) {
        this.trkSeg = trkSeg;
    }

    public GPS getGpsTrk() {
        return gpsTrk;
    }

    public void setGpsTrk(GPS gpsTrk) {
        this.gpsTrk = gpsTrk;
    }
}
