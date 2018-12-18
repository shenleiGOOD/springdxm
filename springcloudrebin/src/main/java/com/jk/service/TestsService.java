package com.jk.service;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class TestsService {
    @Autowired
    private RestTemplate restTemplate;

    public List<User> testquery(){
        List<User> user=restTemplate.getForObject("http://eurekacsioahkj/tests",List.class);
        return user;
    }

    public void addcourse(User user) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("name",user.getName());
        requestEntity.add("counts",user.getCounts().toString());
        restTemplate.postForObject("http://eurekacsioahkj/tests",requestEntity,String.class);
    }
    public void deleteuser(String id){
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("id",id);
        restTemplate.postForObject("http://eurekacsioahkj/deleteuser",requestEntity,String.class);
    }

    public User login(User user) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("name",user.getName());
        requestEntity.add("password",user.getPassword());
        return restTemplate.postForObject("http://eurekacsioahkj/login",requestEntity,User.class);
    }
}
