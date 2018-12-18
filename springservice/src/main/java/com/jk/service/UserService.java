package com.jk.service;

import com.jk.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("app/user")
public interface UserService {
    @GetMapping("tests")
    List<User> queryUser();
    @PostMapping("adduser")
    void adduser(User user);
    @PostMapping("deluser")
    void tests3(@RequestParam("id") String id);
    @PostMapping("finduserbyid")
    User finduserbyid(User user);
    @PostMapping("updateuser")
    void updateuser(User user);
    @PostMapping("login")
    User login(User user);
}
