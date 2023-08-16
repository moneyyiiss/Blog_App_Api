package com.demo.blog.security1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class UserController1 {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String getWelcome(){
        return "Welcome";
    }

    @GetMapping("admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdmin(){
        return "Hi Admin, you have been authenticated successfully";
    }

    @GetMapping("user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getUser(){
        return "Hi User, you have loggined successfully";
    }

    @PostMapping("/user/add")
    public String addUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        userInfoRepository.save(userInfo);
        return "User has been successfully added to db";
    }


}
