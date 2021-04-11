package com.example.demo.domain;


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
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "gps")
public class GPS extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    private Metadata metadata;

    @OneToMany(mappedBy = "gpsWpt", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Waypoint> wpt;

    @OneToMany(mappedBy="gpsTrk", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Track> trk;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.updatedDate = now;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Set<Waypoint> getWpt() {
        return wpt;
    }

    public void setWpt(Set<Waypoint> wpt) {
        this.wpt = wpt;
    }

    public Set<Track> getTrk() {
        return trk;
    }

    public void setTrk(Set<Track> trk) {
        this.trk = trk;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
