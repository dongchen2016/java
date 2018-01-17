package com.dongchen.java.springboot.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author: mdd
 * @date:2018/1/3
 * @描述:
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(Environment env){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        hikariDataSource.setUsername(env.getProperty("spring.datasource.username"));
        hikariDataSource.setPassword(env.getProperty("spring.datasource.password"));
        hikariDataSource.setDriverClassName(env.getProperty("spring.datasource.driverClass"));
        return hikariDataSource;
    }
}
