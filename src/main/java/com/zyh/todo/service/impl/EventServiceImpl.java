package com.zyh.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.EventDAO;
import com.zyh.todo.model.po.Event;
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
    public List<Event> getAll() {
        return eventDAO.getAll();
    }
}