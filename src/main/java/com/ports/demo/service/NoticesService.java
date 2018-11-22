package com.ports.demo.service;

import com.ports.demo.domain.Notices;

import java.util.List;

public interface NoticesService {

    int giveInform(String inform);

    List<Notices> getInform();

    List<Notices> getRecent();

}
