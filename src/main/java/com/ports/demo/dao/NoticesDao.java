package com.ports.demo.dao;

import com.ports.demo.domain.Notices;

import java.util.List;

public interface NoticesDao {

    int giveInform(String inform);

    List<Notices> getInform();

    List<Notices> getRecent();
}
