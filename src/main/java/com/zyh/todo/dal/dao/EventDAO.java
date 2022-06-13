package com.zyh.todo.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyh.todo.dal.mapper.EventMapper;
import com.zyh.todo.model.po.EventPO;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:24
 */
@Repository
public class EventDAO {

    @Autowired
    EventMapper eventMapper;

    public List<EventPO> getAll() {
        return eventMapper.selectAll();
    }

    public boolean insert(EventPO eventPO) {
        eventPO.setUpdateTime(System.currentTimeMillis());
        eventPO.setCreateTime(System.currentTimeMillis());
        return eventMapper.insert(eventPO) == 1;
    }

    public List<EventPO> getTodo() {
        return eventMapper.selectTodo();
    }

    public List<EventPO> getDone() {
        return eventMapper.selectDone();
    }

    public boolean update(EventPO eventPO) {
        eventPO.setUpdateTime(System.currentTimeMillis());
        return eventMapper.updateByPrimaryKey(eventPO) == 1;
    }

    public boolean updateStatusById(int id, int status) {
        return eventMapper.updateStatusById(id, status) == 1;
    }
}