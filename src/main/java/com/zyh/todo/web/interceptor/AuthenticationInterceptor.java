package com.zyh.todo.web.interceptor;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author zhangyiheng03
 * @since 2022/6/14 16:53
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler) {
        try {
            String sessionKey = request.getHeader("X-SessionKey");
            log.info("sessionKey:{}", sessionKey);
        } catch (Exception e) {
            log.error("[op:preHandle] catch-exception,", e);
        }
        return true;
    }
}