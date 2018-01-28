package com.dongchen.java.eurekaclient.controller;

import com.dongchen.java.eurekaclient.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mdd
 * @date:2018/1/28
 * @描述:
 */
@RestController
public class HystrixController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hystrix")
    public String helloConsume(){
        return helloService.helloService();
    }
}
