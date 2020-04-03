package com.stori.flickr_feed.application.resource;

import com.stori.flickr_feed.application.domain.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/feed")
public interface FeedResource {
    @GetMapping
    ResponseEntity<List<Post>> getFeed();
}
