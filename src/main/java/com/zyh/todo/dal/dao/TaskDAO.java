package com.zyh.todo.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.TaskMapper;
import com.zyh.todo.model.po.TaskPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:24
 */
@Repository
public class TaskDAO {

    @Autowired
    TaskMapper taskMapper;

    public boolean insert(TaskPO taskPO) {
        taskPO.setUpdateTime(System.currentTimeMillis());
        taskPO.setCreateTime(System.currentTimeMillis());
        return taskMapper.insert(taskPO) == 1;
    }

    public List<TaskPO> getTodo() {
        return taskMapper.selectTodo();
    }

    public List<TaskPO> getDone() {
        return taskMapper.selectDone();
    }

    public boolean update(TaskPO taskPO) {
        taskPO.setUpdateTime(System.currentTimeMillis());
        return taskMapper.updateByPrimaryKey(taskPO) == 1;
    }

    public boolean updateStatusById(int id, int status) {
        return taskMapper.updateStatusById(id, status) == 1;
    }
}