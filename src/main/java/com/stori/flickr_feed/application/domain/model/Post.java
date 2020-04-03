package com.stori.flickr_feed.application.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private String title;
    private String link;
    private String photo;
    private String author;
    @JsonFormat(pattern = "dd MMM yyyy")
    private Date dateTaken;
}
