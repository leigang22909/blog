package com.lrm.dao;

import com.lrm.pojo.Blog;
import com.lrm.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lenovo
 * @title: BolgDap
 * @projectName blog
 * @description: TODO
 * @date 2021/10/919:12
 */

@Mapper
@Repository
public interface BolgDao {


    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlogQuery();
    //保存博客
    int saveBlog(Blog blog);

    int deleteBlog(Long id);

    int updateBlog(ShowBlog showBlog);

    int deleteBlogAndTag(Long blogId);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();
    //找到最上面的博客
//    List<Blog> findTop(Pageable pageable);

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    List<Blog> findByLikeBlog(String title, boolean recommend, Long type_id);
    //更新views
    int updateViews(Long id);
}
