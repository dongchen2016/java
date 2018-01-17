package com.dongchen.java.service.impl;

import com.dongchen.java.dao.entity.User;
import com.dongchen.java.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: mdd
 * @date:2018/1/1
 * @描述:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public String testIndex(){
        return "this is a test";
    };

    /**
     * 使用jdbctemplate查询用户数据量
     * @param
     * @return
     */
    @Override
    public int countNum(){
        return jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
    };
    /**
     * 根据id查询
     * @param
     * @return
     */
    @Override
    public int countById(int id){
        return  jdbcTemplate.queryForObject("select count(*) from user where id = ?",Integer.class,id);
    };

    /**
     * 根据用户id，查询整条记录
     * @param
     * @return
     */
    @Override
    public User getUserById(int id){
        String sql= "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDepartmentId(resultSet.getInt("department_id"));
                user.setCreateTime(resultSet.getDate("create_time"));
                return user;
            }
        },id);
        return user;
    };
}
