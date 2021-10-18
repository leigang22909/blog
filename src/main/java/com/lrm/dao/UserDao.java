package com.lrm.dao;

import com.lrm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lenovo
 * @title: UserDao
 * @projectName blog
 * @description: TODO
 * @date 2021/10/818:22
 */
@Mapper
@Repository
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);

}
