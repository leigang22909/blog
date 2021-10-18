package com.lrm.service;

import com.lrm.pojo.Type;

import java.util.List;

/**
 * @author lenovo
 * @title: typeService
 * @projectName blog
 * @description: TODO
 * @date 2021/10/823:42
 */
public interface TypeService {


    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);

}
