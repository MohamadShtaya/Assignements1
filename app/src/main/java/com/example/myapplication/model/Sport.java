package com.example.myapplication.model;

public class Sport {
    private String title;
    private String description;

    private String rule;

    public Sport(String title, String description,  String rule) {
        this.title = title;
        this.description = description;

        this.rule = rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRule() {
        return rule;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
