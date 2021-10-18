package com.lrm.web;

import com.lrm.pojo.Picture;
import com.lrm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author lenovo
 * @title: PictureShowController
 * @projectName blog
 * @description: TODO
 * @date 2021/10/1214:32
 */
@Controller
public class PictureShowController {

    @Autowired
    PictureService pictureService;

    @GetMapping("/picture")
    public String pictre(Model model){
        List<Picture> pictures = pictureService.listPicture();
        System.out.println(pictures);
        model.addAttribute("pictures",pictures);
        return "picture";
    }
}
