package com.example.Springbootdemo.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Getter
@Component
@ConfigurationProperties(prefix="app.admin.users")
public class ConfigDemo {
    private List<String> names = new ArrayList<>();
}
