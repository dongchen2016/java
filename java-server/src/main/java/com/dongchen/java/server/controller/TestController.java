package com.dongchen.java.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mdd
 * @date:2017/12/11
 */
@RestController
public class TestController {

    @RequestMapping("/test/receiveMsg")
    public String index(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","mdd");
        map.put("age","25");
        return JSON.toJSONString(map);
    }
}
