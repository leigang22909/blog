package com.lrm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lenovo
 * @title: AboutShowController
 * @projectName blog
 * @description: TODO
 * @date 2021/10/1213:43
 */
@Controller
public class AboutShowController {


    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
