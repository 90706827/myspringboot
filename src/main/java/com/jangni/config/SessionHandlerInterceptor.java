package com.jangni.config;

import com.jangni.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:    自定义拦截处理
 * @Autor: Jangni
 * @Date: Created in  2018/2/24/024 23:51
 */
public class SessionHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //判断用户是否登录否则跳转指定页面
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        if(user == null){
            httpServletResponse.sendRedirect("/user/userInfo.html");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //Controller 方法处理完毕后调用此方法
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //页面渲染完毕后调用此方法，通常用来清除某些资源，类似java语法finally
    }
}
