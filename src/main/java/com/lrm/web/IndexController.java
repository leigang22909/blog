package com.lrm.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrm.NotFoundException;
import com.lrm.dao.BolgDao;
import com.lrm.pojo.Type;
import com.lrm.service.BlogService;
import com.lrm.service.TypeService;
import com.lrm.vo.DetailedBlog;
import com.lrm.vo.FirstPageBlog;
import com.lrm.vo.RecommendBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lenovo
 * @title: IndexController
 * @projectName blog
 * @description: TODO
 * @date 2021/10/811:32
 */

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BolgDao bolgDao;

//    首页展示
    @GetMapping("/")
    public String toIndex(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        System.out.println("allFirstPageBlog：----》" + allFirstPageBlog);
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        return "index";
    }

//    查询
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        PageHelper.startPage(pageNum,1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}
