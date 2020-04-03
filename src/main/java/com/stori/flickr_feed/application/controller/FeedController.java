package com.stori.flickr_feed.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stori.flickr_feed.application.domain.builder.PostBuilder;
import com.stori.flickr_feed.application.domain.model.Feed;
import com.stori.flickr_feed.application.domain.model.Post;
import com.stori.flickr_feed.application.feign.FeedFeignClient;
import com.stori.flickr_feed.application.resource.FeedResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// TODO Create ControllerAdvice for error management
public class FeedController implements FeedResource {
    private static final Logger log = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    private FeedFeignClient feedFeignClient;

    @Autowired
    private PostBuilder builder;

    @Override
    public ResponseEntity<List<Post>> getFeed() {
        List<Post> posts = new ArrayList<>();
        Feed feed = toFeed(feedFeignClient.getFeed().getBody());

        feed.getItems().forEach(i -> posts.add(builder.build(i)));

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    private Feed toFeed(String response) {
        response = response
                .replace("jsonFlickrFeed(", "")
                .replace("})", "}");

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(response, Feed.class);
        } catch (JsonProcessingException e) {
            log.error("Error parsing response string", e);

            // TODO Create custom exception
            throw new NullPointerException("Error parsing response string");
        }
    }
}
