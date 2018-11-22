//package com.ports.demo.java;
//
//import com.ports.demo.dao.DayRemarkDao;
//import com.ports.demo.dao.StudentsDao;
//import com.ports.demo.domain.DayRemarks;
//import com.ports.demo.domain.Students;
//import com.ports.demo.service.CalendarService;
//import com.ports.demo.service.DaysService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class task {
//
//    @Autowired
//    private DaysService daysService;
//
//    @Autowired
//    private DayRemarkDao dayRemarkDao;
//
//    @Autowired
//    private StudentsDao studentsDao;
//
//    @Autowired
//    private CalendarService calendarService;
//
//    //每天选择没有写周计划的学生进行扣分--第一次扣分
////    @Scheduled(cron = "0/5 * * * * ?" )
////    public void first(){
////        List<String> list = daysService.getNull();//获取没有写计划的学生的名单
////        for(String s : list) {
////            String name = s;
////            dayRemarkService.sid(name);//在分数表插入学生的信息
////            int i = dayRemarkService.getScore1(name);//获取分数
////            i = i - 50;
////            int j = dayRemarkService.score1(name, i);
////            System.out.println("a1");
////        }
////    }
//
////    //每天选择没有写周计划的学生进行扣分--第二次扣分
////    @Scheduled(cron = "0/5 * * * * ?" )
////    public void second(){
////        List<String> list = daysService.getNull();//获取没有写计划的学生的名单
////        for(String s : list) {
////            String name = s;
////            int i = dayRemarkService.getScore1(name);//获取分数
////            i = i - 50;
////            int j = dayRemarkService.score1(name, i);
////        }
////    }
//
//
//    //先取学生名单，取分数，统计总数，计算平均数，统计完成度不及格的分数
//
////    @Scheduled(cron = "0/7 * * * * ?" )
////    public void count(){
////        List<Students> student = studentsService.viewStudents();
////        for(Students s : student){
////            String name = s.getName();
////            int dayScore = dayRemarkService.getScore1(name);//取当天的总分数
////            List<Integer> per = daysService.getPer(name);//取当天任务完成度
////            int count = 0;//完成度总分
////            int ded = 0;//扣分情况
////            for(Integer i : per){
////                int score = i;
////                count = count + i;
////                if(score<60){ //完成度不足60，扣10分
////                    ded = ded - 10;
////                }
////            }
////            count = count / per.size();
////            dayScore = dayScore + count - ded;
////            int i = dayRemarkService.score1(name,dayScore);
////            System.out.println("b"+i);
////        }
////    }
//
//
//    //选择所有学生的名单，统计当天所属的周有多少天，选择周扣分，平均分，再计算天分数
////    @Scheduled(cron = "0/9 * * * * ?" )
////    public void weekDed(){
////        List<Students> list = studentsService.viewStudents();
////        int days = calendarService.Days();
////        for(Students s : list){
////            String name = s.getName();
////            int dayScore = dayRemarkService.getScore1(name);
////            int weekScore = dayRemarkService.getWeekScore(name);
////            int score = dayScore - (weekScore / days);
////            dayRemarkService.score1(name,score);
////        }
////    }
//
//
//    @Scheduled(cron = "0/9 * * * * ?" )
//    public void point(){
//        List<Students> list = studentsDao.viewStudents();
//        for(Students s : list){
//            int sid = s.getsid();
//            List<Integer> score = dayRemarkDao.getScore2(sid);
//            int size = score.size();
//            int[] ints = new int[size];
//            for(int i=0; i<size; i++){
//                ints[i]=score.get(i);
//            }
//            Arrays.sort(ints);
//            int finalScore = ints[size/2];
//            studentsDao.saveScore(sid,finalScore);
//        }
//    }
//}
