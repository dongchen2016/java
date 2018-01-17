package com.dongchen.java.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mdd
 * @date:2018/1/15
 * @描述:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/string")
    public String string(){
        stringRedisTemplate.opsForValue().set("aaa", "dfdfd");
        return stringRedisTemplate.opsForValue().get("aaa");
    };

    @RequestMapping("/map")
    public String map(){
        stringRedisTemplate.opsForValue().set("aaa", "111");
        return stringRedisTemplate.opsForValue().get("aaa");
    }
}
