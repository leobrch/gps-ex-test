package com.example.demo.domain;


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

    @Column(name = "desc")
    private String desc;

    @OneToMany(mappedBy = "trkLink", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Link> link;

    @OneToMany(mappedBy = "trkSeg", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<TrackSegment> trkseg;

    @ManyToOne
    @JoinColumn(name = "gps_id")
    private GPS gpsTrk;

    public Track(String name, String desc, List<Link> link, List<TrackSegment> trkseg) {
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.trkseg = trkseg;
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

    public List<TrackSegment> getTrkseg() {
        return trkseg;
    }

    public void setTrkseg(List<TrackSegment> trkseg) {
        this.trkseg = trkseg;
    }

    public GPS getGpsTrk() {
        return gpsTrk;
    }

    public void setGpsTrk(GPS gpsTrk) {
        this.gpsTrk = gpsTrk;
    }
}
