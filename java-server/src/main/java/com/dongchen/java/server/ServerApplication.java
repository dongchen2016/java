package com.dongchen.java.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: mdd
 * @date:2017/12/10
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "ServerApplication");
        SpringApplication.run(ServerApplication.class, args);

    }
}
