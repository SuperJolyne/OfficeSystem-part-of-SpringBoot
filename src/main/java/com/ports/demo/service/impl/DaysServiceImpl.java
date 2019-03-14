package com.ports.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ports.demo.dao.DayRemarkDao;
import com.ports.demo.dao.DaysDao;
import com.ports.demo.domain.Days;
import com.ports.demo.pojo.Context;
import com.ports.demo.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DaysServiceImpl implements DaysService {

    @Autowired
    private DaysDao daysDao;

    @Autowired
    private DayRemarkDao dayRemarkDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> planExist(int sid) {
        String dayRemark = dayRemarkDao.getDayRemark(sid);
        List<Days> list = daysDao.planExist(sid);
        Map<String, Object> map = new HashMap<>();
        map.put(Context.Days_dayRemark,dayRemark);
        map.put(Context.array,list);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String , Object> dayPlans(int sid, String array, String dayRemark) {
        //存天计划部分
        JSONArray jsonArray = JSONArray.parseArray(array);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject Object = jsonArray.getJSONObject(i);
            String did = Object.getString(Context.Days_did);
            String dayPlan = Object.getString(Context.Days_dayPlan);
            int per = Object.getInteger("per");//如果用户的完成度为0，则修改为1
            if (per == 0){
                per = 1;
            }
            if(null == did || did.equals("") || did.equals("undefined")){
                daysDao.dayPlan(sid, dayPlan, per);
            }else {
                daysDao.updatePer(did,per);
            }
        }
        //存天备注部分
        String remark = dayRemarkDao.getDayRemark(sid);
        String sid1 = dayRemarkDao.getDayID(sid);
        if (remark == null) {//判断数据库是否有备注，没有则新建，有则更新
            dayRemarkDao.saveDayRemark(sid, dayRemark);
        } else {
            dayRemarkDao.updateDayRemark(sid, dayRemark);
        }
        //取备注和天计划
        String getRemark = dayRemarkDao.getDayRemark(sid);
        List<Days> list = daysDao.planExist(sid);

        Map<String , Object> map = new HashMap<>();
        map.put(Context.Days_dayRemark,getRemark);
        map.put("array",list);
        return map;
    }

    @Override
    public List<String> getDay() {
        return daysDao.getDay();
    }

    @Override
    public int dayPlan(int sid, String dayPlan, int per) {
        return daysDao.dayPlan(sid,dayPlan,per);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePer(String did, int per) {
        return daysDao.updatePer(did,per);
    }

    @Override
    public List<Days> getDayPlan(int sid,String date) {
        return daysDao.getDayPlan(sid,date);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String , Object> getDayRecord(int sid, String date) {
        Map<String , Object> map = new HashMap<>();
        String koufen = dayRemarkDao.getKoufen(sid, date);
        if (null == koufen || koufen.equals("")){
            koufen = "0";
        }
        String comment = dayRemarkDao.getDayComment(sid,date);
        String dayRemark = dayRemarkDao.getOneRemark(sid, date);
        if (null == comment || comment.equals("")){
            comment = "暂无";
        }
        System.out.println("comment:"+comment);
        List<Days> list = daysDao.getDayRecord(sid, date);
        System.out.println("score:"+koufen);
        map.put("score",koufen);
        map.put("comment",comment);
        map.put("array", list);
        map.put("dayremark", dayRemark);
        return map;
    }

    @Override
    public List<String> getNull() {
        return daysDao.getNull();
    }

    @Override
    public List<Integer> getPer(String name) {
        return daysDao.getPer(name);
    }
}
