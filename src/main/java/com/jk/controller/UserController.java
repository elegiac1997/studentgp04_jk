package com.jk.controller;

import com.jk.pojo.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

/**
 * JK
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register_student")
    public String register(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),1);
        return "index";
    }

    @PostMapping("/register_teacher")
    public String register_teacher(User user){
        System.out.println(user);
        userService.insertUser(user);
        User user1 = userService.findByUserName(user.getUsername());
        userService.insertUserRole(user1.getId(),2);
        return "index";
    }
}
