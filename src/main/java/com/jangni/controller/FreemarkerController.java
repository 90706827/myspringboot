package com.jangni.controller;

import com.jangni.cache.ParamCache;
import com.jangni.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jangni.service.UserService;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/25/025 10:07
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {
    @Autowired
    UserService userService;
    @Autowired
    ParamCache paramCache;

    @RequestMapping("/showUser.html")
    public ModelAndView showUserInfo(Long id){
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user",user);
        view.setViewName("/user");
        return view;
    }
    @RequestMapping("/showUserR.html")
    public ModelAndView showUserR(Long id){
        ModelAndView view = new ModelAndView("redirect:/freemarker/showUser.html");
        return view;
    }
    @RequestMapping("/showUserF.html")
    public String show(){
//        ModelAndView view = new ModelAndView("forward:/freemarker/user/1-1");
//        return view;
       return "forward:/freemarker/user";
    }
    @RequestMapping("/user")
    public ModelAndView showUser(){
        ModelAndView view = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("123");
        view.addObject("user",user);
        view.setViewName("/user");
        return view;
    }

    @RequestMapping("json")
    @ResponseBody
    public User json(Long id){
        return userService.getUserById(id);
    }
}
