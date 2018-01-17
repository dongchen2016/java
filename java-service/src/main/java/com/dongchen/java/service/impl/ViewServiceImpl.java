package com.dongchen.java.service.impl;

import com.dongchen.java.dao.entity.User;
import com.dongchen.java.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: mdd
 * @date:2018/1/13
 * @描述:
 */
@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 根据id
     * 查询用户信息
     * @param id
     * @return
     */
    @Override
    public User getUserById(String id){
        User user =
         jdbcTemplate.queryForObject("select * from user2 where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        },id);
        return user;
    };
}
