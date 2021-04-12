package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "link")
public class Link extends AbstractEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "type")
    private String type;

    @Column(name = "href")
    private String href;

    @ManyToOne
    @JoinColumn(name = "trk_id")
    @JsonBackReference
    private Track trkLink;

    @ManyToOne
    @JoinColumn(name = "metadata_id")
    @JsonBackReference
    private Metadata metadata;

    public Link() {
    }

    public Link(String text) {
        this.text = text;
    }

    public Link(String text, String type, String href) {
        this.text = text;
        this.type = type;
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Track getTrkLink() {
        return trkLink;
    }

    public void setTrkLink(Track trkLink) {
        this.trkLink = trkLink;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
