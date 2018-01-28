package com.dongchen.java.eurekaclient.controller;

import com.dongchen.java.dao.entity.UserInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: mdd
 * @date:2018/1/17
 * @描述:
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;
    @GetMapping("/hello")
    public String index(){

        return "eureka client";
    }

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    @GetMapping("/get/userinfo")
    public UserInfo helloConsumer(String userid){
        //第一种getForEntity
        ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/get/user-info?userid={1}",UserInfo.class,userid);
        UserInfo userInfo = userInfoResponseEntity.getBody();
        //第二种
        Map<String,String> info = new HashMap<>();
        info.put("userid",userid);
        ResponseEntity<UserInfo> userInfoResponseEntityMap = restTemplate.getForEntity("http://HELLO-SERVICE/user-info?userid={userid}",UserInfo.class,info);
        //第三种写法，uri,responseType
        UriComponents uriComponents= UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user-info?userid={userid}").build().expand(userid).encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<UserInfo> userInfoResponseEntityUri = restTemplate.getForEntity(uri,UserInfo.class);

        return userInfo;
    }

    /**
     *
     * @param type:1表示map作为参数，无其他
     * @return
     */
    @GetMapping("/post/userInfo")
    public UserInfo putUserInfo(String userid,String type){
        UserInfo userInfo = new UserInfo();
        Map<String,String> info = new HashMap<String,String>();
        info.put("userid",userid);
        if (type.equals("1")){
            ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.postForEntity(
                    "http://HELLO-SERVICE/post/user-info",info,UserInfo.class);
            userInfo = userInfoResponseEntity.getBody();
        }else if (type.equals("2")){
            ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.postForEntity(
                    "http://HELLO-SERVICE/post/user-info",info,UserInfo.class);
            userInfo = userInfoResponseEntity.getBody();
        }
        return userInfo;
    }
}
