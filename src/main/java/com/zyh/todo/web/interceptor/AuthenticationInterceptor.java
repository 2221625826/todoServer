package com.zyh.todo.web.interceptor;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zyh.todo.util.CookieUtils;
import com.zyh.todo.util.JWTUtils;
import com.zyh.todo.web.UserContext;

/**
 * 身份鉴权校验
 * @author zhangyiheng03
 * @since 2022/6/14 16:53
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        try {
            String token = CookieUtils.getCookie(CookieUtils.LOGIN_TOKEN, request);
            if (StringUtils.isBlank(token)) {
                return false;
            }
            if (JWTUtils.checkToken(token)) {
                Integer userId = JWTUtils.getUserIdFromToken(token);
                UserContext.setUserId(userId);
            } else {
                log.error("[op:preHandle]: token={}", token);
                return false;
            }
        } catch (Exception e) {
            log.error("[op:preHandle] catch-exception,", e);
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler, ModelAndView modelAndView) {
        UserContext.remove();
    }
}