package com.imooc.o2o.entity;

import java.util.Date;

public class PersonInfo {
    //ID
    private Long userId;
    //名字
    private String name;
    private String profileImg;
    private String email;
    private String gender;
    private Integer enableStatus;
    //1.顾客2.店家3.管理员
    private Integer userType;
    private Date creatTime;
    private Date lastEditTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", enableStatus=" + enableStatus +
                ", userType=" + userType +
                ", creatTime=" + creatTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}
