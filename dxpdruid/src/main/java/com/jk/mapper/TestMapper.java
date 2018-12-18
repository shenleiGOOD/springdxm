package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    List<User> queryUser();

    void addUser(@Param("user") User user);
    void deleteuser(@Param("id") String id);

    User login(@Param("name") String name);

    User finduserbyid(@Param("id") String id);

    void updateuser(@Param("user") User user);
}
