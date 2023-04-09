package com.irrigation.system.config;

import java.util.Map;

import org.springframework.core.env.MapPropertySource;

public class TrimmedPropertySource extends MapPropertySource {
	 
    public TrimmedPropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }
 
    @Override
    public Object getProperty(String name) {
        Object value = super.getProperty(name);
        if (value instanceof String) {
            return ((String) value).trim();
        }
        return value;
    }
    
 
}

