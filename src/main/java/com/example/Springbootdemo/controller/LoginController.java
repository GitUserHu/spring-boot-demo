package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {
    final Logger LOG = LogManager.getLogger(LoginController.class);
    @GetMapping("/")
    public ModelAndView login() {
        LOG.info("go to login page");
        return new ModelAndView("login");
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        LOG.info("delete user ["+id+"]");
    }
    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable long id) {
        User user = new User();
        user.setId(id);
        user.setName("LCF");
        return user;
    }
    @PostMapping("/{user}")
    public User updateUserInfo(@PathVariable User user) {
        return user;
    }
}
