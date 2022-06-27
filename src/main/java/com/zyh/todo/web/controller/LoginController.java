package com.zyh.todo.web.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyh.todo.service.LoginService;
import com.zyh.todo.util.http.AjaxResult;
import com.zyh.todo.web.UserContext;

/**
 * @author zhangyiheng03
 * @since 2022/6/27 15:17
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController extends BaseController{

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public AjaxResult login(@RequestParam String username, @RequestParam String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return initFailureResult("账号或密码为空");
        }
        return initSuccessResult(loginService.login(username, password));
    }

}