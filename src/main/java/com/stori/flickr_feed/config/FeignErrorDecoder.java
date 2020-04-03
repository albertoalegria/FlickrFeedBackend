package com.stori.flickr_feed.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class FeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();
    private static final Logger log = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());

        // TODO Create custom exception
        if (status.is4xxClientError() || status.is5xxServerError()) {
            log.error("Error connecting to Feign client:\n{}", response.reason());
        }

        return defaultErrorDecoder.decode(methodKey, response);
    }
}
