package com.lrm.service;

import com.lrm.pojo.User;

/**
 * @author lenovo
 * @title: UserService
 * @projectName blog
 * @description: TODO
 * @date 2021/10/818:17
 */
public interface UserService {

    User checkUser(String username, String password);
}
