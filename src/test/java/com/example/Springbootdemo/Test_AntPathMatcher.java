package com.example.Springbootdemo;

import org.springframework.util.AntPathMatcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Test_AntPathMatcher {
    final static AntPathMatcher antPathMatcher = new AntPathMatcher();
    final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(dtf));
        String pattern = "/static/**";
        String path = "/static/js/test.jpg";
        boolean match = antPathMatcher.match(pattern, path);
        System.out.println("[" + pattern + "] : [" + path + " ] match? " +match);
    }
}
