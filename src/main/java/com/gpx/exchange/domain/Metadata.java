package com.gpx.exchange.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "metadata")
public class Metadata extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "desc", length = 1000)
    private String desc;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "metadata", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Link> link;

    @Column(name = "time")
    private Date time;

    public Metadata() {
    }

    public Metadata(String name, String desc, String author, List<Link> link, Date time) {
        this.name = name;
        this.desc = desc;
        this.author = author;
        this.link = link;
        this.time = time;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
