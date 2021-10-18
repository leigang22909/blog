package com.lrm.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrm.pojo.Blog;
import com.lrm.pojo.Type;
import com.lrm.pojo.User;
import com.lrm.service.BlogService;
import com.lrm.service.TypeService;
import com.lrm.vo.BlogQuery;
import com.lrm.vo.SearchBlog;
import com.lrm.vo.ShowBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lenovo
 * @title: BlogController
 * @projectName blog
 * @description: TODO
 * @date 2021/10/820:42
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    public void setType(Model model){
        model.addAttribute("types",typeService.getAllType());
    }

    //去博客页面，显示博客
    @GetMapping("/blogs")
    public String toBlog(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<BlogQuery> allBlogQuery = blogService.getAllBlogQuery();
        PageInfo<BlogQuery> blogsPageInfo = new PageInfo<>(allBlogQuery);
        model.addAttribute("blogsPageInfo",blogsPageInfo);
        setType(model);
        model.addAttribute("href", "/admin/blogs");
        return "admin/blogs";
    }

    //博客搜索
    @PostMapping("/blogs/search")
    public String blogSearch(SearchBlog searchBlog, Model model,
                             @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<BlogQuery> allBlogQuery = blogService.searchByTitleOrTypeOrRecommend(searchBlog);
        PageInfo<BlogQuery> blogsPageInfo = new PageInfo<>(allBlogQuery);
        model.addAttribute("blogsPageInfo",blogsPageInfo);
        setType(model);
        model.addAttribute("message", "查询成功");
        return "admin/blogs :: blogList";//返回bloglist片段，不然会在网页嵌套一个网页
    }

    //去新增页面
    @GetMapping("/blogs/input")
    public String toBlogAdd(Model model){
        setType(model);
        return "admin/blogs-input";
    }

    //增加blog
    @PostMapping("/blogs/add")
    public String blogAdd(Blog blog, RedirectAttributes attributes, HttpSession session){
        System.out.println("前端传来的blog" + blog);
        blog.setUser((User)session.getAttribute("user"));
        //设置blog的type
        blog.setType((typeService.getType(blog.getTypeId())));
        //设置blog中的typeid属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        blogService.saveBlog(blog);
        attributes.addFlashAttribute("message","新增成功");
        return "redirect:/admin/blogs";
    }

    //去编辑
    @GetMapping("/blogs/{id}/update")
    public String toBlogUpdate(@PathVariable Long id,Model model,Blog blog){
            ShowBlog blogById = blogService.getBlogById(id);
            List<Type> allType = typeService.getAllType();
            model.addAttribute("blog", blogById);
            model.addAttribute("types", allType);
            return "admin/blogs-input";
    }
    //编辑
    @PostMapping("/blogs/update")
    public String updateBlog(ShowBlog showBlog,RedirectAttributes attributes){
        blogService.updateBlog(showBlog);
        System.out.println("updateBlog的showBlog"+showBlog);
        attributes.addFlashAttribute("message", "修改成功");
        return "redirect:/admin/blogs";
    }

    //删除

    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }
}
