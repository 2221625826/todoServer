package com.zyh.todo.dal.mapper;

import lombok.Data;

@Data
public class AccountPO {
    /**
     * userId
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}