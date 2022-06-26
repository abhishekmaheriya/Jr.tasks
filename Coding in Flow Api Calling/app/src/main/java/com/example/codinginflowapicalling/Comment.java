package com.example.codinginflowapicalling;

import com.google.gson.annotations.SerializedName;

public  class Comment {

    @SerializedName("body")
    private String body;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("postId")
    private int postId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
