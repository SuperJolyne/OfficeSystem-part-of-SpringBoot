package com.ports.demo.service;

import com.ports.demo.domain.Pictures;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface PicturesService {

    Pictures getID();

    void savePict(String pict, int sid);

    void saveAuto1(String auto, int sid);

    void savePict1(String pict1, int sid);
    //学生手动图片
    Map<String ,Object> getPict() throws Exception;
    //系统随机抓拍图片
    List<byte[]> getAuto(int sid, String date) throws Exception;
    //教师抓拍图片
    Map<String ,Object> getPict1() throws FileNotFoundException, Exception;

    void deletePict1();
}
