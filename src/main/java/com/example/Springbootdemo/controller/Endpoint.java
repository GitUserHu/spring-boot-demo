package com.example.Springbootdemo.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//@Component
@Path("/endpoint")
public class Endpoint {
    @GET
    public String endPoint() {
            return "endpoint";
    }
}
