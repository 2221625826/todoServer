package com.zyh.todo.service;

import java.util.List;

import com.zyh.todo.model.vo.EventVO;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:27
 */

public interface EventService {
    /**
     * 获取所有事件
     * @return 事件列表
     */
    List<EventVO> getAll();

    /**
     * 添加任务
     * @param eventVO 参数
     * @return 是否成功
     */
    boolean addTask(EventVO eventVO);

    /**
     * 获取所有未开始和进行中任务
     * @return 所有待办事件
     */
    List<EventVO> getTodo();

    /**
     * 获取所有已完成任务
     * @return 所有已完成任务
     */
    List<EventVO> getDone();

    /**
     * 修改任务
     * @param eventVO 新的内容
     * @return 是否成功
     */
    boolean editTask(EventVO eventVO);

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