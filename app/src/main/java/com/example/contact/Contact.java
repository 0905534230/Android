package com.example.contact;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private int mId;
    private String fullname;
    private String company;
    private String title;
    private String mobile;
    private String email;
    private String createdAt;
    private String avatar;

    public Contact(){}

    public Contact(String fullname, String company, String title, String mobile, String email ,
                   int mId ) {
        this.fullname = fullname;
        this.company = company;
        this.title = title;
        this.mobile = mobile;
        this.email = email;
        this.mId = mId;
        //this.createdAt = createdAt;
        //this.avatar = avatar;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}















