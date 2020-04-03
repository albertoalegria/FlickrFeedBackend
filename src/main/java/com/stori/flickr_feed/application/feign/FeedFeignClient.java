package com.stori.flickr_feed.application.feign;

import com.stori.flickr_feed.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feed", url = "https://www.flickr.com/services/feeds/photos_public.gne?format=json", configuration = FeignConfig.class)
public interface FeedFeignClient {
    @GetMapping
    ResponseEntity<String> getFeed();
}