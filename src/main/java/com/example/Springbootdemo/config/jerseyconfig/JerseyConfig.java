package com.example.Springbootdemo.config.jerseyconfig;

import com.example.Springbootdemo.controller.Endpoint;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/*") // default mapping is '/*', change @ApplicationPath to change the mapping pattern.
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Endpoint.class);
    }
}
