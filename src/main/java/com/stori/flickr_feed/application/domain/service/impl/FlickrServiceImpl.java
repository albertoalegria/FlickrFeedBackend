package com.stori.flickr_feed.application.domain.service.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.test.TestInterface;
import com.stori.flickr_feed.application.domain.service.FlickrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.Collections;

public class FlickrServiceImpl implements FlickrService {
    private static final Logger log = LoggerFactory.getLogger(FlickrService.class);

    @Value("${flickr.api.key:}")
    private String key;

    @Value("${flickr.api.secret:}")
    private String secret;

    @Override
    public void login() {
        if (key.isEmpty() || secret.isEmpty()) {
            throw new NullPointerException("Undefined key or secret");
        }

        Flickr flickr = new Flickr(key, secret, new REST());
//        TestInterface testInterface = flickr.getTestInterface();
//        Collection result = testInterface.echo(Collections.EMPTY_MAP);
    }
}
