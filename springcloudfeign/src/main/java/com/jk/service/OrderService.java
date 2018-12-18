package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "eurekacsioahkj")//声明当前接口时一个feign客户端
public interface OrderService extends UserService{

}
