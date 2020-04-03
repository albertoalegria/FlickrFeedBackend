package com.stori.flickr_feed.application.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Item {
    private String title;

    private String link;

    private Map<String, String> media;

    @JsonProperty("date_taken")
    private Date dateTaken;

    private String description;

    private String published;

    private String author;

    @JsonProperty("author_id")
    private String authorId;

    private String tags;

    public String getMedia() {
        return media.get("m");
    }
}
