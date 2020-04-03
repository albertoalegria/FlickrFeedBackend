package com.stori.flickr_feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FlickrFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlickrFeedApplication.class, args);
	}

}
