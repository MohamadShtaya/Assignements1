package com.example.myapplication.model;

import com.example.myapplication.model.Sport;

import java.util.List;

public interface iSportDa {
    List<Sport> getSports(String cat);
    String[] getcategories(int i);

}
