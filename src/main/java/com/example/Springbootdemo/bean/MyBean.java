package com.example.Springbootdemo.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MyBean {
    @Value("${server.port}")
    private String serverPort;
    @Value("${sys.secret}")
    private String sysSecret;
    @Value("${sys.intVal}")
    private int sysIntVal;
    @Value("${sys.longVal}")
    private long sysLongVal;
    @Value("${sys.uuid}")
    private String sysUUID;

}
