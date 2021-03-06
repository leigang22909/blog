package com.lrm.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * @title: Tag
 * @projectName blog
 * @description: TODO
 * @date 2021/10/816:23
 */
public class Tag {

    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
