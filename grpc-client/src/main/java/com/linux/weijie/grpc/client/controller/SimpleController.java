package com.linux.weijie.grpc.client.controller;

import com.linux.weijie.grpc.client.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SimpleController {


    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.receiveGreeting(name);
    }

}
