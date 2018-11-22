package com.ports.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.dao.PicturesDao;
import com.ports.demo.dao.StudentsDao;
import com.ports.demo.domain.Pictures;
import com.ports.demo.normal.Context;
import com.ports.demo.service.PicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PicturesServiceImpl implements PicturesService {

    @Autowired
    private PicturesDao picturesDao;

    @Autowired
    private StudentsDao studentsDao;

    @Override
    public Pictures getID() {
        return picturesDao.getID();
    }

    @Override
    public void savePict(String pict, int sid) {
        String s = picturesDao.getPictByNow(sid);
        if(s==null) {
            System.out.println("pict");
            picturesDao.savePict(pict,sid);
        }else {
            picturesDao.savePict_2(pict, sid);
        }
    }

    @Override
    public void saveAuto1(String auto, int sid) {
        String s = picturesDao.getAutoByNow(sid);
        if(s==null) {
            System.out.println("auto");
            picturesDao.saveAuto1(auto, sid);
        }else {
            String save = s + "+" + auto;
            picturesDao.saveAuto1(save, sid);
        }
    }

    @Override
    public void savePict1(String pict1, int sid){
        picturesDao.savePict1(pict1,sid);
    }

    //学生手动图片
    @Override
    public Map<String ,Object> getPict() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Pictures> list = picturesDao.getPict();
        for(Pictures p : list){
            String path = p.getPict();
            if(path != null) {
                int sid = p.getSid();
                String name = studentsDao.getNameBySid(sid);

                File f = new File(path);
                InputStream input = new FileInputStream(f);
                byte[] bytes = new byte[input.available()];
                input.read(bytes);
                BASE64Encoder encoder = new BASE64Encoder();
                String o = encoder.encode(bytes);

                BASE64Decoder decoder = new BASE64Decoder();
                byte[] a = decoder.decodeBuffer(o);
                map.put(name, a);
            }
        }
        return map;
    }

    @Override
    public List<byte[]> getAuto(int sid, String date) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        List<byte[]> list = new ArrayList<>();
        String s = picturesDao.getAuto(sid,date);
        if(s!=null) {
            String[] ss = s.split("\\+");
            for (int i = 0; i < ss.length; i++) {
                File f = new File(ss[i]);
                InputStream input = new FileInputStream(f);
                byte[] bytes = new byte[input.available()];
                input.read(bytes);

                BASE64Encoder encoder = new BASE64Encoder();
                String o = encoder.encode(bytes);

                BASE64Decoder decoder = new BASE64Decoder();
                byte[] a = decoder.decodeBuffer(o);
                list.add(a);
            }
        }

        return list;
    }

    @Override
    public Map<String, Object> getPict1() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Pictures> list = picturesDao.getPict1();
        for(Pictures p : list){
            String path = p.getPict1();
            if(path != null && !path.equals("null")) {
                int sid = p.getSid();
                String name = studentsDao.getNameBySid(sid);

                System.out.println(name);
                File f = new File(path);
                InputStream input = new FileInputStream(f);
                byte[] bytes = new byte[input.available()];
                input.read(bytes);
                BASE64Encoder encoder = new BASE64Encoder();
                String o = encoder.encode(bytes);

                BASE64Decoder decoder = new BASE64Decoder();
                byte[] a = decoder.decodeBuffer(o);
                map.put(name, a);
            }
        }
        return map;
    }

    @Override
    public void deletePict1() {
        List<String> list = picturesDao.viewPict1();
        for(String s : list){
            if(s!=null) {
                picturesDao.deletePict();
                break;
            }
        }
    }
}
