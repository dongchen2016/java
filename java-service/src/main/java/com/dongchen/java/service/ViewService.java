package com.dongchen.java.service;


import com.dongchen.java.dao.entity.User;

/**
 * @author: mdd
 * @date:2018/1/13
 * @描述:
 */
public interface ViewService {

    /**
     * 根据id
     * 查询用户信息
     * @param id
     * @return
     */
    User getUserById(String id);
}
