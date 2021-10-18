package com.lrm.service.impl;

import com.github.pagehelper.PageInfo;
import com.lrm.NotFoundException;
import com.lrm.dao.BolgDao;
import com.lrm.pojo.Blog;
import com.lrm.service.BlogService;
import com.lrm.uitl.MarkdownUtils;
import com.lrm.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lenovo
 * @title: BlogServiceImpl
 * @projectName blog
 * @description: TODO
 * @date 2021/10/919:11
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BolgDao bolgDao;

    @Override
    public PageInfo<Blog> findBlogByLike(SearchBlog blog) {
        List<Blog> list = bolgDao.findByLikeBlog(blog.getTitle(),blog.isRecommend(),blog.getTypeId());
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return bolgDao.getBlogById(id);
    }

    @Override
    public List<BlogQuery> getAllBlogQuery() {
        return bolgDao.getAllBlogQuery();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return bolgDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        System.out.println("updateBlog设置的date：" + new Date());
        System.out.println("updateBlog设置的date后get的：" + showBlog.getUpdateTime());
        return bolgDao.updateBlog(showBlog);
    }

    @Override
    public int deleteBlog(Long id) {
        bolgDao.deleteBlogAndTag(id);
        bolgDao.deleteBlog(id);
        return 1;
    }

    @Override
    public List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog) {
        return bolgDao.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public void transformRecommend(SearchBlog searchBlog) {

    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return bolgDao.getAllFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = bolgDao.getAllRecommendBlog();
        List<RecommendBlog> allRecommendedBlog = new ArrayList<>();
        for (RecommendBlog recommendBlog : allRecommendBlog) {
            if (recommendBlog.isRecommend() == true) {
                allRecommendedBlog.add(recommendBlog);
            }
        }
        return allRecommendedBlog;
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return bolgDao.getSearchBlog(query);
    }


//    @Override
//    public List<Blog> listRecommendBlogTop(Integer size) {
//        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
//        Pageable pageable = PageRequest.of(0, size, sort);
//        return blogMapper.findTop(pageable);
//    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = bolgDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedBlog;
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return bolgDao.getByTypeId(typeId);
    }

}
