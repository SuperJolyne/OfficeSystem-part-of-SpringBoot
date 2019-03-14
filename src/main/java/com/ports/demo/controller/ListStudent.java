package com.ports.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ports.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ListStudent {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/teacher/listStudent", method = RequestMethod.POST)
    public JSONObject listStudent(MultipartFile file) throws IOException {
        System.out.println("文件已到达");
        String s[] = file.getOriginalFilename().split("\\.");
        String houzui = s[s.length-1];
        String result = "false";
        if (houzui.equals("csv")){
            InputStreamReader isr = new InputStreamReader(file.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null){
               list.add(line);
             }

            //有bug,如果csv最后一行有回车，回车行为空，会失败
            for(int i=1; i<list.size(); i++){
                String[] ss = list.get(i).split(",");
                String name = ss[0];
                String sex = ss[1];
                String num = ss[2];
                String course = ss[3];
                String school = ss[4];
                String college = ss[5];
                String classes = ss[6];
                System.out.println(name+" "+sex+" "+num+" "+course+" "+school+" "+college+" "+classes);
                int ii = studentsService.listStudents(name,sex,num,course,school,college,classes);
                if(ii != 0){
                    result = "true";
                }
            }
        }

        JSONObject json = new JSONObject();
        json.put("res", result);
        return json;
    }
}
