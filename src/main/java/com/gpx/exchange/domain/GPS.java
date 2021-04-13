package com.gpx.exchange.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gps")
public class GPS extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    private Metadata metadata;

    @OneToMany(mappedBy = "gpsWpt", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Waypoint> wpt;

    @OneToMany(mappedBy="gpsTrk", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Track> trk;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    public GPS() {
    }

    public GPS(Metadata metadata, List<Waypoint> wpt, List<Track> trk, Date createdDate, Date updatedDate) {
        this.metadata = metadata;
        this.wpt = wpt;
        this.trk = trk;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @PrePersist
    public void onCreate() {
        Date now = new Date();
        this.createdDate = now;
        this.updatedDate = now;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = new Date();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Waypoint> getWpt() {
        return wpt;
    }

    public void setWpt(List<Waypoint> wpt) {
        this.wpt = wpt;
    }

    public List<Track> getTrk() {
        return trk;
    }

    public void setTrk(List<Track> trk) {
        this.trk = trk;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
