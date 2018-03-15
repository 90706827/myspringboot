package com.jangni.cache;

import com.jangni.dao.UserDao;
import com.jangni.entity.Menu;
import com.jangni.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/26/026 21:00
 */
@Service
public class ParamCache {

    @Autowired
    UserDao userDao;

    @Cacheable(value = "menu", key = "#id")
    public User getMenu(Long id){
        System.out.println("加载缓存。。。");
        User user = userDao.getUser(1);
        return user;
    }
}
