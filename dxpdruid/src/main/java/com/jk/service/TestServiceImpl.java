package com.jk.service;

import com.jk.mapper.TestMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<User> queryUser(){
        return testMapper.queryUser();
    }

    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        testMapper.addUser(user);
    }
    @Override
    public void deleteuser(String id){
        testMapper.deleteuser(id);
    }

    @Override
    public User login(User user) {
        User users=testMapper.login(user.getName());
        return users;
    }

    @Override
    public User finduserbyid(String id) {
        return testMapper.finduserbyid(id);
    }

    @Override
    public void updateuser(User user) {
        testMapper.updateuser(user);
    }
}
