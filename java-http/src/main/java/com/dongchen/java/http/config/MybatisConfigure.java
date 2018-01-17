package com.dongchen.java.http.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.dongchen.java")
@PropertySource("classpath:db.properties")
@MapperScan(basePackages = {"com.dongchen.java.dao.*"})
public class MybatisConfigure {

    //数据源ORACLE
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }


}