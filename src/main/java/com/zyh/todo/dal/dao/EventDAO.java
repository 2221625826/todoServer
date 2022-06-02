package com.zyh.todo.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.EventMapper;
import com.zyh.todo.model.po.Event;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:24
 */
@Repository
public class EventDAO {

    @Autowired
    EventMapper eventMapper;
    public List<Event> getAll() {
        return eventMapper.selectAll();
    }
}