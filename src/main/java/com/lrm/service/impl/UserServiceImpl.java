package com.lrm.service.impl;

import com.lrm.dao.UserDao;
import com.lrm.pojo.User;
import com.lrm.service.UserService;
import com.lrm.uitl.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 * @title: UserServiceImpl
 * @projectName blog
 * @description: TODO
 * @date 2021/10/818:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
