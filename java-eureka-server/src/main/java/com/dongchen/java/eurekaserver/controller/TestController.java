package com.dongchen.java.eurekaserver.controller;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index(){
        return "hello World";
    }
}
