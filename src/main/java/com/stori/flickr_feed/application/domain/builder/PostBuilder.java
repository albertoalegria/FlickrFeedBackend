package com.stori.flickr_feed.application.domain.builder;

import com.stori.flickr_feed.application.domain.model.Item;
import com.stori.flickr_feed.application.domain.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostBuilder {
    public Post build(Item item) {
        Post post = new Post();

        // Extract author name
        post.setAuthor(item.getAuthor().replace("nobody@flickr.com (\"", "").replace("\")", ""));
        post.setDateTaken(item.getDateTaken());
        post.setLink(item.getLink());
        post.setPhoto(item.getMedia());
        post.setTitle(item.getTitle());

        return post;
    }
}
