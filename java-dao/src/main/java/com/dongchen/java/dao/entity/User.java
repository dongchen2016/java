package com.dongchen.java.dao.entity;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: mdd
 * @date:2018/1/3
 * @描述:
 */
@Setter
@Getter
public class User {

    private int id;

    private String name;

    private int departmentId;

    private Date createTime;
}
