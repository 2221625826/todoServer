package com.zyh.todo.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.AccountMapper;
import com.zyh.todo.model.po.AccountPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 10:17
 */
@Repository
public class AccountDAO {
    @Autowired
    AccountMapper accountMapper;

    public AccountPO getAccount(String username) {
        return accountMapper.selectByUsername(username);
    }
}