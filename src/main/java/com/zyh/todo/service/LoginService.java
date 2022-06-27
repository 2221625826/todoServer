package com.zyh.todo.service;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 15:12
 */

public interface LoginService {
    /**
     * 用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return 登录token
     */
    String login(String username, String password);
}