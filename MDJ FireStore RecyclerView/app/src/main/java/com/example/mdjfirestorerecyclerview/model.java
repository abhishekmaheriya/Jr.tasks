package com.example.mdjfirestorerecyclerview;

public class model {
   private String name, email;
   private String itemname;
   private int price;

    public model() {
    }

    public model(String itemname, int price) {
        this.itemname = itemname;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public model(String name, String email) {
    this.name = name;
    this.email = email;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
