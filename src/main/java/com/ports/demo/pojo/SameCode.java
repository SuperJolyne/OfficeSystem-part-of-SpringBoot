package com.ports.demo.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Calendar;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SameCode {

    public static List<JSONObject> Calendar(List<Calendar> list) throws ParseException {

        String temp= list.get(0).getDatelist().split("-")[0];

        List<JSONObject> listJson = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        for(Calendar c : list){
            String date  = c.getDatelist();
            //将日期分割
            String[] strings = date.split("-");
            String month = strings[0];
            String day = strings[1];

            JSONObject json = new JSONObject();
            json.put(Context.Calendar_month,month);
            json.put(Context.Calendar_day,day);
            json.put(Context.Calendar_status,c.getWorknot());
            json.put(Context.Calendar_time,c.getTimes());
            json.put(Context.Calendar_week,c.getWeek());
            json.put(Context.Calendar_weekday,c.getWeekday());

/**
 * 传输结构已经改变下面代码不需要了
 */
//            //添加1，2月份进map
//            if(temp.equals(month)){
//                listJson.add(json);
//            }else {
//                JSONArray array = JSONArray.parseArray(JSON.toJSONString(listJson));
//                map.put(month,array);
//                listJson.clear();
//                listJson.add(json);
//                temp=month;
//            }
//            //添加3月份进map
//            JSONArray array = JSONArray.parseArray(JSON.toJSONString(listJson));
//            map.put(month,array);

            listJson.add(json);
        }

        return listJson;
    }

    public synchronized static JSONObject SavePicture(String s, String type) throws IOException {
        //获取图片名
        JSONObject json = JSONObject.parseObject(s);
        String sid = json.getString("sid");
        //设置路径和保存名
        String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = Context.Path +date+sid+type;

        File f = new File(path);
        if (!f.getParentFile().exists()){
            f.getParentFile().mkdir();
        }
        if (!f.exists()){
            f.createNewFile();
        }

        byte[] bytes = json.toJSONString().getBytes();
        OutputStream out1 = new FileOutputStream(path);
        out1.write(bytes);
        out1.flush();
        out1.close();

        JSONObject j = new JSONObject();
        j.put("path",path);
        j.put("sid",sid);

        return j;
    }
}

