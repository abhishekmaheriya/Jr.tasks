package com.example.myapplication;

public class Student {
    int intGlcode;
    String name, gender;
    boolean isSelected;

    public Student() {
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Student(int intGlcode, String name, String gender, boolean isSelected) {
        this.intGlcode = intGlcode;
        this.name = name;
        this.gender = gender;
        this.isSelected = isSelected;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public Student(int intGlcode, String name, boolean isSelected) {
        this.intGlcode = intGlcode;
        this.name = name;
        this.isSelected = isSelected;
    }
    public Student(int intGlcode, String name) {
        this.intGlcode = intGlcode;
        this.name = name;
    }
    public Student(String name) {
    }
    public int getIntGlcode() {
        return intGlcode;
    }
    public void setIntGlcode(int intGlcode) {
        this.intGlcode = intGlcode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
