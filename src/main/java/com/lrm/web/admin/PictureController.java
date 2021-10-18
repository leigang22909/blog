package com.lrm.web.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrm.pojo.Picture;
import com.lrm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author lenovo
 * @title: PictureController
 * @projectName blog
 * @description: TODO
 * @date 2021/10/1021:46
 */
@Controller
@RequestMapping("/admin")
public class PictureController {

    @Autowired
    PictureService pictureService;
    @GetMapping("/pictures")
    public String pictures(Model model,
                           @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Picture> pictures = pictureService.listPicture();
        PageInfo<Picture> pageInfo = new PageInfo<>(pictures);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }


    //跳转到页面保存
    @GetMapping("/pictures/input")
    public String input(Model model){
        model.addAttribute("picture",new Picture());
        return "admin/pictures-input";
    }

    //保存页面
    @PostMapping("/pictures")
    public String post(Picture picture, RedirectAttributes redirectAttributes){

        int i = pictureService.savePicture(picture);
        if (i == 0){
            redirectAttributes.addFlashAttribute("message","新增失败");
        }else {
            redirectAttributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/pictures";
    }

    //跳转到页面编辑页面

    @GetMapping("/pictures/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("picture",pictureService.getPicture(id));
        return "admin/pictures-input";
    }

    //编辑
    @PostMapping
    public String editPost(Picture picture ,RedirectAttributes attributes){
        int i = pictureService.updatePicture(picture);
        if (i == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/pictures";
    }

    //删除
    @GetMapping("/pictures/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        pictureService.deletePicture(id);
        attributes.addFlashAttribute("message","删除成功了");
        return "redirect:/admin/pictures";
    }
}
