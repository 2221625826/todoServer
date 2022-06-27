package com.zyh.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zyh.todo.dal.dao.TagDAO;
import com.zyh.todo.dal.dao.TaskDAO;
import com.zyh.todo.dal.dao.TaskTagDAO;
import com.zyh.todo.model.enums.TaskStatus;
import com.zyh.todo.model.po.TagPO;
import com.zyh.todo.model.po.TaskPO;
import com.zyh.todo.model.po.TaskTagPO;
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

    @Autowired
    TaskTagDAO taskTagDAO;

    @Autowired
    TagDAO tagDAO;

    @Override
    public boolean addTask(int userId, TaskVO taskVO) {
        TaskPO taskPO = TaskPO.of(taskVO);
        taskPO.setUserId(userId);
        taskPO.setStatus(TaskStatus.TODO.getCode());
        boolean res = taskDAO.insert(taskPO);
        for (TagPO tagPO : taskVO.getTags()) {
            TaskTagPO taskTagPO = new TaskTagPO();
            taskTagPO.setTagId(tagPO.getId());
            taskTagPO.setTaskId(taskPO.getId());
            res &= taskTagDAO.insert(taskTagPO);
        }
        return res;
    }

    @Override
    public List<TaskVO> getTodo(int userId) {
        List<TaskVO> todoList = Lists.newArrayList();
        for (TaskPO taskPO : taskDAO.getTodo(userId)) {
            TaskVO taskVO = TaskVO.of(taskPO);
            List<TagPO> tagPOList = Lists.newArrayList();
            for (TaskTagPO taskTagPO : taskTagDAO.selectByTaskId(taskPO.getId())) {
                tagPOList.add(tagDAO.getById(taskTagPO.getTagId()));
            }
            taskVO.setTags(tagPOList);
            todoList.add(taskVO);
        }
        return todoList;
    }

    @Override
    public List<TaskVO> getDone(int userId) {
        List<TaskVO> doneList = Lists.newArrayList();
        for (TaskPO taskPO : taskDAO.getDone(userId)) {
            TaskVO taskVO = TaskVO.of(taskPO);
            List<TagPO> tagPOList = Lists.newArrayList();
            for (TaskTagPO taskTagPO : taskTagDAO.selectByTaskId(taskPO.getId())) {
                tagPOList.add(tagDAO.getById(taskTagPO.getTagId()));
            }
            taskVO.setTags(tagPOList);
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
        boolean res = taskDAO.update(taskPO);
        taskTagDAO.delete(taskVO.getId());
        for (TagPO tagPO : taskVO.getTags()) {
            TaskTagPO taskTagPO = new TaskTagPO();
            taskTagPO.setTagId(tagPO.getId());
            taskTagPO.setTaskId(taskPO.getId());
            res &= taskTagDAO.insert(taskTagPO);
        }
        return res;
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