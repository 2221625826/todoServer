package com.zyh.todo.dal.mapper;

import java.util.List;

import com.zyh.todo.model.po.TaskPO;

public interface TaskMapper {

    int insert(TaskPO record);

    TaskPO selectByPrimaryKey(Integer id);

    List<TaskPO> selectTodo(Integer userId);

    List<TaskPO> selectDone(Integer userId);

    int updateStatusById(int id, int status);

    int updateByPrimaryKey(TaskPO taskPO);
}