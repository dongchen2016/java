package com.dongchen.java.eurekaclient.controller;

import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: mdd
 * @date:2018/1/17
 * @描述:
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/hello")
    public String index(){
        return "eureka client";
    }
}
