package com.zuzu.ng2boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by ZPACHOLC on 05.05.2017.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String text;

    LocalDateTime start;

    LocalDateTime end;

    @ManyToOne
    @JsonIgnore
    Resource resource;

    @JsonProperty("resource")
    public Long getResourceId() {
        return resource.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
