package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.AccountPO;
import java.util.List;

public interface AccountMapper {
    AccountPO selectByUsername(String username);
}