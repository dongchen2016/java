package com.dongchen.java.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: mdd
 * @date:2017/12/7
 */
@SpringBootApplication
public class HttpApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "HttpApplication");
        SpringApplication.run(HttpApplication.class, args);

    }
}
