package com.jangni.controller;

import com.jangni.cache.ParamCache;
import com.jangni.entity.User;
import com.jangni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/26/026 22:11
 */
@Controller
@RequestMapping("/cache")
public class CacheContrller {
    @Autowired
    ParamCache paramCache;
    @Autowired
    UserService userService;

    @RequestMapping("/menu.html")
    public ModelAndView cache(){
        ModelAndView view = new ModelAndView();
        User menu = paramCache.getMenu(1L);
        menu.setName("张三");
        userService.updateInfo(menu);
        User user = new User();
        user.setName("李四");
        user.setDepartmentId(1);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        userService.insertUser(user);
        view.addObject("menu",menu);
        view.setViewName("/menu");
        return view;
    }
}
