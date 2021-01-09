package com.sunny.enterprise.whole.global.beans;

import java.util.List;

public class Project {
    String name;
    List<String> subProjectNames;

    public List<String> getSubProjectNames() {
        return subProjectNames;
    }

    public void setSubProjectNames(List<String> subProjectNames) {
        this.subProjectNames = subProjectNames;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
