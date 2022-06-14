package com.zyh.todo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.EventDAO;
import com.zyh.todo.model.enums.TaskStatus;
import com.zyh.todo.model.po.EventPO;
import com.zyh.todo.model.vo.EventVO;
import com.zyh.todo.service.EventService;
import com.zyh.todo.util.exception.ServiceException;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public boolean addTask(EventVO eventVO) {
        EventPO eventPO = EventPO.of(eventVO);
        if (Objects.nonNull(eventPO.getCompleteTime()) && eventPO.getCompleteTime() < System.currentTimeMillis()) {
            throw new ServiceException("结束时间不可用！");
        }
        eventVO.setStatus(TaskStatus.TODO.getCode());
        return eventDAO.insert(eventPO);
    }

    @Override
    public List<EventVO> getTodo() {
        return eventDAO.getTodo().stream().map(EventVO::of).collect(Collectors.toList());
    }

    @Override
    public List<EventVO> getDone() {
        return eventDAO.getDone().stream().map(EventVO::of).collect(Collectors.toList());
    }

    @Override
    public boolean editTask(EventVO eventVO) {
        EventPO eventPO = EventPO.of(eventVO);
        if (eventPO.getId() < 0) {
            throw new ServiceException("非法ID！");
        }
        if (!TaskStatus.getMap().containsKey(eventPO.getStatus())) {
            throw new ServiceException("非法状态！");
        }
        if (Objects.nonNull(eventPO.getCompleteTime()) && eventPO.getCompleteTime() < System.currentTimeMillis()) {
            throw new ServiceException("结束时间不可用！");
        }
        return eventDAO.update(eventPO);
    }

    @Override
    public boolean doTask(int id) {
        return eventDAO.updateStatusById(id, TaskStatus.DOING.getCode());
    }

    @Override
    public boolean finishTask(int id) {
        return eventDAO.updateStatusById(id, TaskStatus.DONE.getCode());
    }

    @Override
    public boolean deprecatedTask(int id) {
        return eventDAO.updateStatusById(id, TaskStatus.DEPRECATED.getCode());
    }


}