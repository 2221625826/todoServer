package com.zyh.todo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.EventDAO;
import com.zyh.todo.model.enums.TaskStatus;
import com.zyh.todo.model.po.EventPO;
import com.zyh.todo.model.vo.EventVO;
import com.zyh.todo.service.EventService;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public List<EventVO> getAll() {
        return eventDAO.getAll().stream().map(EventVO::of).collect(Collectors.toList());
    }

    @Override
    public boolean addTask(EventVO eventVO) {
        eventVO.setStatus(TaskStatus.TODO.getCode());
        return eventDAO.insert(EventPO.of(eventVO));
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
        return eventDAO.update(EventPO.of(eventVO));
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