package com.dongchen.java.springboot.controller;

import com.dongchen.java.dao.entity.User;
import com.dongchen.java.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: mdd
 * @date:2018/1/13
 * @描述:
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/freemarker/index.html",method = RequestMethod.GET)
    public String index(String id, Model model){
        User user = viewService.getUserById(id);
        model.addAttribute("user",user);
        return  "/test";
    }


    @RequestMapping(value = "/redirect/index.html",method = RequestMethod.GET)
    public String redirectIndex(String id){
        return "redirect:/view/redirect/index";
    }

    @ResponseBody
    @RequestMapping(value = "/redirect/index",method = RequestMethod.GET)
    public String redirect(String id){
        return "这是重定向";
    }


    @RequestMapping(value = "/forward/index.html",method = RequestMethod.GET)
    public String forwardIndex(String id){
        return "forward:/view/forward/index";
    }

    @ResponseBody
    @RequestMapping(value = "/forward/index",method = RequestMethod.GET)
    public String forward(String id){
        return "这是转发";
    }
}
