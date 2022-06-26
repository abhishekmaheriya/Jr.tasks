package com.example.recyclerviewwithviewpager;

import java.io.Serializable;

public class Model implements Serializable {
    int img;
    String title,subTitle;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Model(int img, String title, String subTitle) {
        this.img = img;
        this.title = title;
        this.subTitle = subTitle;
    }
}
