package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "metadata")
public class Metadata extends AbstractEntity {
    private String name;
    private String desc;
    private String author;
    private String link;
    private LocalDateTime time;
}
