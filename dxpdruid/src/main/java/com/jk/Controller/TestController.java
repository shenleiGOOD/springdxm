package com.jk.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.User;
import com.jk.service.TestService;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController implements UserService {
    @Autowired
    private TestService testService;

    @Override
    public List<User> queryUser() {
        System.out.println("get");
        List<User> user=testService.queryUser();
        return user;
    }

    @Override
    public void adduser(@RequestBody User user) {
        testService.addUser(user);
    }

    @Override
    public void tests3(String id) {
        testService.deleteuser(id);
    }

    @Override
    public User finduserbyid(@RequestBody User user) {
        return testService.finduserbyid(user.getId());
    }

    @Override
    public void updateuser(@RequestBody User user) {
        testService.updateuser(user);
    }
    @Override
    public User login(@RequestBody User user){
        return testService.login(user);
    }
    /*@RequestMapping(value="tests",method = RequestMethod.GET)
    public List<User> tests1(){
        System.out.println("get");
    List<User> user=testService.queryUser();
    return user;
    }
    @RequestMapping(value="tests",method = RequestMethod.POST)
    public void tests2(User user){
        testService.addUser(user);
    }
    @RequestMapping(value="deleteuser",method = RequestMethod.POST)
    public void tests3(User user){
        testService.deleteuser(user.getId());
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public User tests4(User user){
        return testService.login(user);
    }*/
}
