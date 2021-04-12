package com.example.demo.dto;

import java.io.Serializable;

public class LinkDTO implements Serializable {
    private static final long serialVersionUID = -1920698981918985905L;
    private String text;
    private String type;
    private String href;

    public LinkDTO(String text, String type, String href) {
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
}
