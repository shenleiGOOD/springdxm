package com.jk.controller;

import com.jk.model.User;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("toindex")
    public String toindex(){
        return "index";
    }
    @GetMapping("toadd")
    public String toadd(){
        return "add";
    }
    @GetMapping("tologin")
    public String tologin(){
        return "login";
    }
    @GetMapping("order")
    @ResponseBody
    public List<User> queryOrderInfo(){
        return orderService.queryUser();
    }
    @PostMapping("adduser")
    @ResponseBody
    public void adduser(User user){
         orderService.adduser(user);
    }
    @PostMapping("deleteuser")
    @ResponseBody
    public void tests3(String id) {
        orderService.tests3(id);
    }

    @PostMapping("finduserbyid")
    @ResponseBody
    public User finduserbyid(User user) {
        return orderService.finduserbyid(user);
    }

    @PostMapping("updateuser")
    @ResponseBody
    public void updateuser( User user) {
        orderService.updateuser(user);
    }
    @PostMapping("login")
    @ResponseBody
    public String login( User user) {
        String login="1";
        User users=orderService.login(user);
        if (users != null){
            login="2";
            if (users.getPassword().equals(user.getPassword())){
                login="3";
            }
        }
        return login;
    }
}
