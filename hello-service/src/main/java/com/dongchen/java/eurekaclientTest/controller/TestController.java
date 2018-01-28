package com.dongchen.java.eurekaclientTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @author: mdd
 * @date:2018/1/17
 * @描述:
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/hello")
    public String index() throws Exception{
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("hello-service");
        logger.info("实例个数：" + serviceInstanceList.size());
        for (ServiceInstance instance : serviceInstanceList){
            logger.info("/hello, host：" + instance.getHost()+",port:"+instance.getPort()+
                    "，uri:"+ instance.getUri()+ ", service_id：" + instance.getServiceId());
        }

        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        return "hello world";
    }

    @GetMapping("/get/user-info")
    public Map<String, String> userService(String userid){
        Map<String,String> userInfo= new HashMap<String,String>();
        if (userid.equals("1")){
         userInfo.put("userId","1");
         userInfo.put("password","11111");
        }else if (userid.equals("2")){
            userInfo.put("userId","2");
            userInfo.put("password","222222");
        }else {
            userInfo.put("userId",userid);
            userInfo.put("password","");
        }
        return userInfo;
    }

}
