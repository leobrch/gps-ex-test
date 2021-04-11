package com.example.demo.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "track")
public class Track extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @OneToMany(mappedBy = "trkLink", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<LinkType> link;

    @OneToMany(mappedBy = "trkSeg", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<TrackSegment> trkseg;

    @ManyToOne
    @JoinColumn(name = "gps_id", nullable = false)
    private GPS gpsTrk;

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

    public Set<LinkType> getLink() {
        return link;
    }

    public void setLink(Set<LinkType> link) {
        this.link = link;
    }

    public Set<TrackSegment> getTrkseg() {
        return trkseg;
    }

    public void setTrkseg(Set<TrackSegment> trkseg) {
        this.trkseg = trkseg;
    }

    public GPS getGpsTrk() {
        return gpsTrk;
    }

    public void setGpsTrk(GPS gpsTrk) {
        this.gpsTrk = gpsTrk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(name, track.name) && Objects.equals(desc, track.desc) && Objects.equals(link, track.link) && Objects.equals(trkseg, track.trkseg) && Objects.equals(gpsTrk, track.gpsTrk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, link, trkseg, gpsTrk);
    }
}
