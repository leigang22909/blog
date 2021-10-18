package com.lrm.service;

import com.lrm.pojo.Picture;

import java.util.List;

/**
 * @author lenovo
 * @title: PictureService
 * @projectName blog
 * @description: TODO
 * @date 2021/10/1021:42
 */
public interface PictureService {

    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
