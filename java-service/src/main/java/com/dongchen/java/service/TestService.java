package com.dongchen.java.service;


import com.dongchen.java.dao.entity.User;

/**
 * @author: mdd
 * @date:2018/1/1
 * @描述:
 */
public interface TestService {

    String testIndex();

    /**
     * 使用jdbctemplate查询用户数据量
     * @param
     * @return
     */
    int countNum();

    /**
     * 根据id查询
     * @param
     * @return
     */
    int countById(int id);

    /**
     * 根据用户id，查询整条记录
     * @param
     * @return
     */
    User getUserById(int id);
}
