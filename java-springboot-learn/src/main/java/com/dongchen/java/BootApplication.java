package com.dongchen.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: mdd
 * @date:2017/12/7
 */
@SpringBootApplication
@EnableAutoConfiguration
public class BootApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "BootApplication");
        SpringApplication.run(BootApplication.class, args);

    }
}
