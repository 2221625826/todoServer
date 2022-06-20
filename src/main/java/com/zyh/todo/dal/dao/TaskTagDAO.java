package com.zyh.todo.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.TaskTagMapper;
import com.zyh.todo.model.po.TaskTagPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/17 17:13
 */
@Repository
public class TaskTagDAO {
    @Autowired
    TaskTagMapper taskTagMapper;

    public boolean insert(TaskTagPO taskTagPO) {
        return taskTagMapper.insert(taskTagPO) == 1;
    }

    public List<TaskTagPO> selectByTaskId(int taskId) {
        return taskTagMapper.selectByTaskId(taskId);
    }

    public void delete(int taskId) {
        taskTagMapper.deleteByTaskId(taskId);
    }
}