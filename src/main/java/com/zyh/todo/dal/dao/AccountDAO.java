package com.zyh.todo.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.AccountMapper;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 10:17
 */
@Repository
public class AccountDAO {
    @Autowired
    AccountMapper accountMapper;
}