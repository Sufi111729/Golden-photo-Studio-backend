// File: bookingbackend/src/main/java/com/sufi/photoStudio/Config/ModelMapperConfig.java
package com.sufi.photoStudio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
