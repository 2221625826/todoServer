package com.zyh.todo.web.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.todo.service.EventService;
import com.zyh.todo.util.http.AjaxResult;

/**
 * @author zhangyiheng03
 * @since 2022/6/2 15:32
 */
@RestController
@Slf4j
@RequestMapping("/todo")
public class TodoController extends BaseController{

    @Autowired
    EventService eventService;

    @RequestMapping("/getAll")
    public AjaxResult getAll(){
        return initSuccessResult(eventService.getAll());
    }
}