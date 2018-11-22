package com.ports.demo.dao;

import com.ports.demo.domain.Pictures;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicturesDao {

    Pictures getID();

    int savePict(@Param("pict") String pict, @Param("sid")int sid);

    int savePict_2(@Param("pict") String pict, @Param("sid")int sid);

    int savePict1(@Param("pict1") String pict1, @Param("sid")int sid);

    int saveAuto1(@Param("auto") String auto, @Param("sid")int sid);

    List<Pictures> getPict();

    String getPictByNow(int sid);

    String getPict1ByNow(int sid);

    List<Pictures> getPict1();

    String getAuto(@Param("sid") int sid, @Param("date") String date);

    String getAutoByNow(int sid);

    void deletePict();

    List<String> viewPict1();
}
