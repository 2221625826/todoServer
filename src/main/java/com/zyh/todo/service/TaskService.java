package com.zyh.todo.service;

import java.util.List;

import com.zyh.todo.model.vo.TaskVO;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */

public interface TaskService {

    /**
     * 添加任务
     * @param taskVO 参数
     * @return 是否成功
     */
    boolean addTask(TaskVO taskVO);

    /**
     * 获取所有未开始和进行中任务
     * @return 所有待办事件
     */
    List<TaskVO> getTodo(int userId);

    /**
     * 获取所有已完成任务
     * @return 所有已完成任务
     */
    List<TaskVO> getDone(int userId);

    /**
     * 修改任务
     * @param taskVO 新的内容
     * @return 是否成功
     */
    boolean editTask(TaskVO taskVO);

    /**
     * 任务开始进行
     * @param id 任务id
     * @return 是否成功
     */
    boolean doTask(int id);

    /**
     * 任务完成
     * @param id 任务id
     * @return 是否成功
     */
    boolean finishTask(int id);

    /**
     * 废弃任务
     * @param id 任务id
     * @return 是否成功
     */
    boolean deprecatedTask(int id);
}