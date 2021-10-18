package com.lrm.dao;

import com.lrm.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lenovo
 * @title: PictureDao
 * @projectName blog
 * @description: TODO
 * @date 2021/10/1021:31
 */
@Mapper
@Repository
public interface PictureDao {

    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
