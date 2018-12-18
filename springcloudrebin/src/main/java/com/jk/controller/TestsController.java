package com.jk.controller;

import com.jk.model.User;
import com.jk.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class TestsController {
    @Autowired
    private TestsService testsService;
    @GetMapping("order")
    @ResponseBody
    public List<User> testquery(){
        System.out.println("接受");
        List<User> user=testsService.testquery();
        return user;
    }
    @GetMapping("toIndex")
    public String toindex(){
        return "index";
    }
    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }
    @GetMapping("toadd")
    public String toadd(){
        return "add";
    }
    @PostMapping("addcourse")
    @ResponseBody
    public void addcourse(User user){
        testsService.addcourse(user);
    }
    @PostMapping("deleteuser")
    @ResponseBody
    public void deleteuser(String id){
        testsService.deleteuser(id);
    }
    @PostMapping("login")
    @ResponseBody
    public String login(User user, HttpServletRequest request){
        String login="1";
        User users=testsService.login(user);
        if (users != null){
            login="2";
            if (user.getPassword().equals(users.getPassword())){
                request.getSession().setAttribute("ss",users);
                login="3";
            }
        }
        return login;
    }
}
