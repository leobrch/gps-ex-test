package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "link")
public class LinkType extends AbstractEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "type")
    private String type;

    @Column(name = "href")
    private String href;

    @ManyToOne
    @JoinColumn(name = "trk_id", nullable = false)
    private Track trkLink;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkType linkType = (LinkType) o;
        return Objects.equals(text, linkType.text) && Objects.equals(type, linkType.type) && Objects.equals(href, linkType.href) && Objects.equals(trkLink, linkType.trkLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, type, href, trkLink);
    }
}
