package com.stori.flickr_feed.application.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Feed {
    private String title;

    private String link;

    private String description;

    private Date modified;

    private String generator;

    private List<Item> items = new ArrayList<>();

}
