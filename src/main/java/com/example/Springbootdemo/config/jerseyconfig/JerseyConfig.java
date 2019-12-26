package com.example.Springbootdemo.config.jerseyconfig;
/**
 * Jersey是用来的代替SpringMVC或者Webflux的，二者用其一。这个Demo选择Webflux
 * 该配置只是用作代码示例，在项目运行时不会配置Jersey。
 */

import com.example.Springbootdemo.controller.Endpoint;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/*") // default mapping is '/*', change @ApplicationPath to change the mapping pattern.
//@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Endpoint.class);
    }
}
