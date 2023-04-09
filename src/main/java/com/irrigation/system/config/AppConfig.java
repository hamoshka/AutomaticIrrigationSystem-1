package com.irrigation.system.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration
public class AppConfig {
 
    @Autowired
    private ConfigurableEnvironment env;
 
    @PostConstruct
    public void init() {
        Map<String, Object> props = new HashMap<>();
        // add properties to props map
        env.getPropertySources().addFirst(new TrimmedPropertySource("myProps", props));
    }
 
}

