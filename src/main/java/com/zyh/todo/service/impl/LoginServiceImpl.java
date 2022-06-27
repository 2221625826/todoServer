package com.zyh.todo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.AccountDAO;
import com.zyh.todo.model.po.AccountPO;
import com.zyh.todo.service.LoginService;
import com.zyh.todo.util.JWTUtil;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 15:14
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    public String login(String username, String password) {
        AccountPO account = accountDAO.getAccount(username);
        if (StringUtils.equals(account.getPassword(), password)) {
            return JWTUtil.createToken(String.valueOf(account.getId()));
        }
        return null;
    }
}