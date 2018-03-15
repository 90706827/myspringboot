package com.jangni.controller;

import com.jangni.entity.User;
import com.jangni.form.OrderPostForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @ModelAttribute
    public void findUserById(Model model){
        User user = new User();
        user.setId(123456);
        user.setName("吴红云");
        model.addAttribute("user",user);
    }

    //?批量一个字符 * 匹配多个字符
    @RequestMapping("/userInfo?{id}.html")
    public String foo(Model model, @PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        user.setName("吴红云");
//        model.addAttribute("user",user);
        return "/UserInfo.btl";
    }
    @RequestMapping(path="/userInfo.json")
    public List<User> json(Model model){
        List list = new ArrayList();
        User user = new User();
        user.setId(1002);
        user.setName("吴红云");
        list.add(user);
        return list;
    }
    @RequestMapping(value = "/userInfo.html")
    public String foo1(Model model){
        User user = new User();
        user.setId(10032);
        user.setName("吴红云12");
//        model.addAttribute("user",user);
        return "/UserInfo.btl";
    }
    @RequestMapping(value = "/user.html",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView user(ModelAndView view,@RequestBody User user){
        view.addObject("user",user);
        view.setViewName("/UserInfo.btl");
        return view;
    }

    @RequestMapping(value = "/user1.html")
    public ModelAndView user1(ModelAndView view,@RequestParam(name="id",required = true)Integer id,String name){
        User user = new User();
        user.setId(id==null?1:id);
        user.setName(name==null?"111":name);
        view.addObject("user",user);
        view.setViewName("/UserInfo.btl");
        return view;
    }
    @RequestMapping(value = "/order.html")
    public ModelAndView order(ModelAndView view, OrderPostForm orderPostForm){
        User user = new User();
        user.setId(12);
        user.setName("12");
        if (orderPostForm!=null){
            System.out.println(orderPostForm.getOrder().getName());
            System.out.println(orderPostForm.getDetails().get(0).getName());
        }
        view.addObject("user",user);
        view.addObject("orderForm",orderPostForm);
        view.setViewName("/UserInfo.btl");
        return view;
    }

}
