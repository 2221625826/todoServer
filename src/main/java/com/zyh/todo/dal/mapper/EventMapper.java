package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.EventPO;
import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventPO record);

    EventPO selectByPrimaryKey(Integer id);

    List<EventPO> selectAll();

    int updateByPrimaryKey(EventPO record);

    List<EventPO> selectTodo();

    List<EventPO> selectDone();

    int updateStatusById(int id, int status);
}