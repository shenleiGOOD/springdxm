package com.jk.service;

import com.jk.model.User;

import java.util.List;

public interface TestService {
    List<User> queryUser();

    void addUser(User user);

    void deleteuser(String id);

    User login(User user);

    User finduserbyid(String id);

    void updateuser(User user);

}
