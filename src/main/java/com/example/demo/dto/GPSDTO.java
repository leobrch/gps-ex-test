package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class GPSDTO implements Serializable {
    private static final long serialVersionUID = 6221253060659929280L;
    private Long id;
    private MetadataDTO metadata;
    private Date createdDate;
    private Date updatedDate;

    public GPSDTO(Long id, MetadataDTO metadata, Date createdDate, Date updatedDate) {
        this.id = id;
        this.metadata = metadata;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public MetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDTO metadata) {
        this.metadata = metadata;
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
