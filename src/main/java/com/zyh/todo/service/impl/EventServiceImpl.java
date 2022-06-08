package com.zyh.todo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.todo.dal.dao.EventDAO;
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
    public Boolean addTask(EventVO eventVO) {
        return eventDAO.insert(EventPO.of(eventVO));
    }
}