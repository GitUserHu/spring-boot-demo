package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Jia Bing
 * @date: 2019/12/09 21:24
 * Webflux形式的控制器
 */
@RestController
public class UserController {

    Logger log = LogManager.getLogger(UserController.class);

    @GetMapping("/user/{id}")
    public ResponseEntity<Mono<User>> getUser(@PathVariable long id) {
        HttpStatus status = id == 0?NOT_FOUND:OK;
        return new ResponseEntity<>(Mono.just(new User(id, "getUser")) , status);
    }
    @GetMapping("/users/{name}")
    public ResponseEntity<Flux<User>> getUserList(@PathVariable String name) {
        User userA = new User(1, name);
        User userB = new User(2, name);
        User userC = new User(3, name);
        Flux<User> userList = Flux.fromIterable(Arrays.asList(userA, userB, userC));
        return new ResponseEntity<>(userList, OK);
    }
    @GetMapping("/non-blocking")
    public ResponseEntity<Mono<User>> forNonBlockingTest() {
        Mono<User> just = Mono.just(new User(100, "non-blocking-test"));
        //log.info("running here");
        System.out.println("running here");
        return new ResponseEntity<>(just, OK);
    }
    @GetMapping(value="/allUsers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<User>> getAllUsers() {
        Flux<User> allUsers = Flux.fromIterable(Arrays.asList(
                new User(1, "user1"),
                new User(2, "user2"))).delayElements(Duration.ofMillis(2000));
        return new ResponseEntity<>(allUsers, OK);
    }
}
