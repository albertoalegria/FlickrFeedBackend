package com.stori.flickr_feed.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public Feign.Builder builder() {
        return Feign.builder().errorDecoder(new FeignErrorDecoder());
    }

    @Bean
    public Logger.Level loggerLeymvel() {
        return Logger.Level.FULL;
    }
}
