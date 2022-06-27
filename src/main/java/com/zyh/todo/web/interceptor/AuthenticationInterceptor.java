package com.zyh.todo.web.interceptor;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.zyh.todo.util.CookieUtil;
import com.zyh.todo.util.JWTUtil;
import com.zyh.todo.web.UserContext;

/**
 * @author zhangyiheng03
 * @since 2022/6/14 16:53
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        try {
            String token = CookieUtil.getCookie(CookieUtil.LOGIN_TOKEN, request);
            if (StringUtils.isBlank(token)) {
                return false;
            }
            if (JWTUtil.checkToken(token)) {
                Integer userId = JWTUtil.getUserIdFromToken(token);
                UserContext.setUserId(userId);
            } else {
                log.error("[token error]: token={}", token);
                return false;
            }
        } catch (Exception e) {
            log.error("[op:preHandle] catch-exception,", e);
        }
        return true;
    }
}