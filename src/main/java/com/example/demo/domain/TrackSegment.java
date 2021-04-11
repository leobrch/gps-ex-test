package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "trackSegment")
public class TrackSegment extends AbstractEntity {
    @OneToMany(mappedBy = "trkSeg", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<WaypointSegment> trkpt;

    @ManyToOne
    @JoinColumn(name = "trk_id", nullable = false)
    private Track trkSeg;

    public Set<WaypointSegment> getTrkpt() {
        return trkpt;
    }

    public void setTrkpt(Set<WaypointSegment> trkpt) {
        this.trkpt = trkpt;
    }

    public Track getTrkSeg() {
        return trkSeg;
    }

    public void setTrkSeg(Track trkSeg) {
        this.trkSeg = trkSeg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackSegment that = (TrackSegment) o;
        return Objects.equals(trkpt, that.trkpt) && Objects.equals(trkSeg, that.trkSeg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trkpt, trkSeg);
    }
}
