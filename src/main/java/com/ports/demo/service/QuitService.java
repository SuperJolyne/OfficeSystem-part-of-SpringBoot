package com.ports.demo.service;

import com.ports.demo.domain.Quit;

import java.util.List;

public interface QuitService {

    int saveQuit(int sid);

    List<String> getQuit(int sid);

    int quitRemark(int sid, String date, String remark);

    List<Quit> getQuitRemark();
}