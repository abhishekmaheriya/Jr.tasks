package com.example.becodeyapicalling;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ApiModel {
    @SerializedName("support")
    private Support support;
    @SerializedName("data")
    private List<Data> data;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("total")
    private int total;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("page")
    private int page;

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public  class Support {
        @SerializedName("text")
        private String text;
        @SerializedName("url")
        private String url;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public  class Data {
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("last_name")
        private String last_name;
        @SerializedName("first_name")
        private String first_name;
        @SerializedName("email")
        private String email;
        @SerializedName("id")
        private int id;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
