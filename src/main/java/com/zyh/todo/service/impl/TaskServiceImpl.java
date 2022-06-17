package com.zyh.todo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zyh.todo.dal.dao.TaskDAO;
import com.zyh.todo.model.enums.TaskStatus;
import com.zyh.todo.model.po.TaskPO;
import com.zyh.todo.model.vo.TaskVO;
import com.zyh.todo.service.TaskService;
import com.zyh.todo.util.exception.ServiceException;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDAO taskDAO;

    @Override
    public boolean addTask(TaskVO taskVO) {
        TaskPO taskPO = TaskPO.of(taskVO);
        taskPO.setStatus(TaskStatus.TODO.getCode());
        return taskDAO.insert(taskPO);
    }

    @Override
    public List<TaskVO> getTodo() {
        List<TaskVO> todoList = Lists.newArrayList();
        for (TaskPO taskPO : taskDAO.getTodo()) {
            TaskVO taskVO = TaskVO.of(taskPO);
            todoList.add(taskVO);
        }
        return todoList;
    }

    @Override
    public List<TaskVO> getDone() {
        List<TaskVO> doneList = Lists.newArrayList();
        for (TaskPO taskPO : taskDAO.getDone()) {
            TaskVO taskVO = TaskVO.of(taskPO);
            doneList.add(taskVO);
        }
        return doneList;
    }

    @Override
    public boolean editTask(TaskVO taskVO) {
        TaskPO taskPO = TaskPO.of(taskVO);
        if (taskPO.getId() < 0) {
            throw new ServiceException("非法ID！");
        }
        if (!TaskStatus.getMap().containsKey(taskPO.getStatus())) {
            throw new ServiceException("非法状态！");
        }
        return taskDAO.update(taskPO);
    }

    @Override
    public boolean doTask(int id) {
        return taskDAO.updateStatusById(id, TaskStatus.DOING.getCode());
    }

    @Override
    public boolean finishTask(int id) {
        return taskDAO.updateStatusById(id, TaskStatus.DONE.getCode());
    }

    @Override
    public boolean deprecatedTask(int id) {
        return taskDAO.updateStatusById(id, TaskStatus.DEPRECATED.getCode());
    }


}