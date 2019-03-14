package com.ports.demo.dao;

import com.ports.demo.domain.Quit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuitDao {

    int saveQuit(int sid);

    List<String> getQuit(int sid);

    int quitRemark(@Param("sid") int sid, @Param("reason") String remark);

    List<Quit> getQuitRemark(@Param("sid") String sid, @Param("date") String date);
}
