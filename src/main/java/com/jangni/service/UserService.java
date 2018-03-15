package com.jangni.service;

import com.jangni.dao.UserDao;
import com.jangni.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/25/025 10:11
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public User getUserById(Long id) {
        User user = new User();
        user.setId(10032);
        user.setName("吴红云10032");
        return user;
    }
    public void updateInfo(User user) {
    userDao.updateInfo(user);
    }
    public Integer insertUser(final User user) {
        return userDao.insertUser(user);
    }
}
