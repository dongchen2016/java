package com.dongchen.java.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mdd
 * @date:2018/1/13
 * @描述:
 */
@Controller
public class ExceptionController extends AbstractErrorController{

    Log log = LogFactory.getLog(ExceptionController.class);

    @Autowired
    ObjectMapper objectMapper;

    public ExceptionController(){
        super(new DefaultErrorAttributes());
    }

    @RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> model = Collections.unmodifiableMap(getErrorAttributes(request,false));

        //获取异常，有可能为空
        Throwable cause = getCause(request);
        int status = (Integer) model.get("status");
        //错误信息
        String message = (String) model.get("message");

        //友好提示
        String errorMessage = getErrorMessage(cause);

        log.info(status+", " + message,cause);
        response.setStatus(status);
        if (!isJsonRequest(request)){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addAllObjects(model);
            modelAndView.addObject("errorMessage",errorMessage);
            modelAndView.addObject("status",status);
            modelAndView.addObject("cause",cause);
            return modelAndView;
        }else {
            Map<String,Object> error = new HashMap<>();
            error.put("success",false);
            error.put("errorMessage",errorMessage);
            error.put("message",message);
            return null;
        }
    }
    @Override
    public String getErrorPath(){
        return "";
    };

    protected Throwable getCause(HttpServletRequest request){
        Throwable error = (Throwable) request.getAttribute("java.servlet.error.exception");
        if (error !=null){

            while (error instanceof ServletException && error.getCause() != null){
                error = ((ServletException) error).getCause();
            }
        }
        return error;
    }

    protected String getErrorMessage(Throwable ex){
        return "服务器错误，请联系管理员";
    }

    protected boolean isJsonRequest(HttpServletRequest request){
        String requestUri = (String) request.getAttribute("java.servlet.error.request_uri");
        if (requestUri != null && requestUri.endsWith(".json")){
            return true;
        }else {
            return false;
        }
    }
}
