package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MetadataDTO implements Serializable {
    private static final long serialVersionUID = 77241896792643835L;
    private String name;
    private String desc;
    private String author;
    private List<LinkDTO> link;
    private Date time;

    public MetadataDTO(String name, String desc, String author, List<LinkDTO> link, Date time) {
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

    public List<LinkDTO> getLink() {
        return link;
    }

    public void setLink(List<LinkDTO> link) {
        this.link = link;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
