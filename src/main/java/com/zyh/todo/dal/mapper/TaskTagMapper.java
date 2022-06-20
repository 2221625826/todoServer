package com.zyh.todo.dal.mapper;

import com.zyh.todo.model.po.TaskTagPO;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TaskTagMapper {

    int insert(TaskTagPO record);

    int deleteByTaskId(@Param("taskId") Integer taskId);

    List<TaskTagPO> selectByTaskId(@Param("taskId") Integer taskId);
}