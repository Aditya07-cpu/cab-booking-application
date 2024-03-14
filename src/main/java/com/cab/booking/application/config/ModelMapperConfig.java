package com.cab.booking.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean("modelMapper")
    public ModelMapper modelMapperConfig() {
        return new ModelMapper();
    }
}
