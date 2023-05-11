package com.ebanma.cloud.car.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ebanma.cloud.user.api.UserApi;
import com.ebanma.cloud.user.api.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CarController {

    @Reference(version = "${dubbo.provider.version}", application = "${dubbo.application.id}")
    private UserApi userApi;

    @RequestMapping("/save")
    public Object saveUser(@RequestBody UserInfoDTO userInfoDTO) {
        System.out.println("【消费者服务】>> 添加人员" + userInfoDTO);
        return userApi.saveUser(userInfoDTO);
    }

    @RequestMapping("/list")
    public Object listUser() {
        System.out.println("【消费者服务】>> 获取人员列表");
        return userApi.getUserLits();
    }
}