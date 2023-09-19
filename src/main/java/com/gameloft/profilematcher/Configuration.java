package com.gameloft.profilematcher;

import com.gameloft.profilematcher.utils.CustomMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CustomMapper modelMapper() {
        return new CustomMapper();
    }
}
