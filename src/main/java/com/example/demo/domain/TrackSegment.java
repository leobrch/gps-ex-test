package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "trackSegment")
public class TrackSegment extends AbstractEntity {
    @OneToMany(mappedBy = "trkSeg", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Waypoint> trkpt;

    @ManyToOne
    @JoinColumn(name = "trk_id")
    private Track trkSeg;

    public TrackSegment(List<Waypoint> trkpt) {
        this.trkpt = trkpt;
    }

    public List<Waypoint> getTrkpt() {
        return trkpt;
    }

    public void setTrkpt(List<Waypoint> trkpt) {
        this.trkpt = trkpt;
    }

    public Track getTrkSeg() {
        return trkSeg;
    }

    public void setTrkSeg(Track trkSeg) {
        this.trkSeg = trkSeg;
    }
}
