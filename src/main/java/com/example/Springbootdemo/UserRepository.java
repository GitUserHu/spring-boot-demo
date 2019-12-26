package com.example.Springbootdemo;

import com.example.Springbootdemo.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

/**
 * @author Jia Bing
 * @date: 2019/12/19 21:36
 */
public interface UserRepository extends Repository<User, Long> {
    User findById();
    Page<User> findAllByNameEquals(String name);

}

