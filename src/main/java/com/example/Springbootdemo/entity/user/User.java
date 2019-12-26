package com.example.Springbootdemo.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", nullable = false)
    private long id;
    @Column(name = "USER_NAME", nullable = false)
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public User() {}

}
