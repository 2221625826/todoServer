package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.Event;
import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Event record);

    Event selectByPrimaryKey(Integer id);

    List<Event> selectAll();

    int updateByPrimaryKey(Event record);
}