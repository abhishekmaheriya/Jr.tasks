package com.example.mdjfirebasedatabasemultipleinsertion;

public class DataModel {
    String name, cource, duration;

    public DataModel(String name, String cource, String duration) {
        this.name = name;
        this.cource = cource;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
