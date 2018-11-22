package com.ports.demo.normal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.domain.Calendar;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SameCode {

    public static Map<String,Object> Calendar(List<Calendar> list) throws ParseException {

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


            //添加1，2月份进map
            if(temp.equals(month)){
                listJson.add(json);
            }else {
                JSONArray array = JSONArray.parseArray(JSON.toJSONString(listJson));
                map.put(month,array);
                listJson.clear();
                listJson.add(json);
                temp=month;
            }
            //添加3月份进map
            JSONArray array = JSONArray.parseArray(JSON.toJSONString(listJson));
            map.put(month,array);
        }

        return map;
    }

    public synchronized static JSONObject SavePicture(MultipartFile file, String type) throws IOException {
        //获取图片名
        String originalFilename = file.getOriginalFilename();
        String fileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        int sid = Integer.parseInt(fileName);
        //设置路径和保存名
        String date=new SimpleDateFormat("yyyMMddHHmmss").format(java.util.Calendar.getInstance().getTime());
        String manual = "manual";
        String path = Context.Path +date+sid+manual+".jpg";

        byte[] bytes = file.getBytes();
        OutputStream out1 = new FileOutputStream(path);
        out1.write(bytes);
        out1.flush();
        out1.close();

        JSONObject json = new JSONObject();
        json.put("path",path);
        json.put("sid",sid);

        return json;
    }
}

