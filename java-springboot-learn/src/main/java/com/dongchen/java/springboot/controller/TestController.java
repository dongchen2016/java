package com.dongchen.java.springboot.controller;

import com.dongchen.java.dao.entity.User;
import com.dongchen.java.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: mdd
 * @date:2018/1/1
 * @描述:
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;



    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    @ResponseBody
    public String say(){
        return testService.testIndex();
    }

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ResponseBody
    public int count(){
        int count = testService.countNum();
        int countById = testService.countById(122);

        User user = testService.getUserById(122);

        return count;
    }
}
