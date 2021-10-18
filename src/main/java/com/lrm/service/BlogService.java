package com.lrm.service;

import com.github.pagehelper.PageInfo;
import com.lrm.pojo.Blog;
import com.lrm.vo.*;

import java.util.List;

/**
 * @author lenovo
 * @title: BlogService
 * @projectName blog
 * @description: TODO
 * @date 2021/10/918:58
 */
public interface BlogService {

    public PageInfo<Blog> findBlogByLike(SearchBlog blog);

    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    int deleteBlog(Long id);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    //修改recommend,因为recommend从前台接收只能接收字符串，但数据库中的Integer类型，所以转一下
    void transformRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    //最底下的博客推荐
//    List<Blog> listRecommendBlogTop(Integer size);

    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);


}
