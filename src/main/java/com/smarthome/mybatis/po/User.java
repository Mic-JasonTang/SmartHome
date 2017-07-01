package com.smarthome.mybatis.po;

import java.util.Date;

public class User {
    private Integer userId;

    private String userType;

    private String userName;

    private String userPwd;

    private String userSex;

    private String userBirth;

    private String userEmail;

    private String userTel;

    private String userIDCard;

    private Date userdatetime;

    public User(Integer userId, String userType, String userName, String userPwd, String userSex, String userBirth, String userEmail, String userTel, String userIDCard, Date userdatetime) {
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.userIDCard = userIDCard;
        this.userdatetime = userdatetime;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserIDCard() {
        return userIDCard;
    }

    public void setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard == null ? null : userIDCard.trim();
    }

    public Date getUserdatetime() {
        return userdatetime;
    }

    public void setUserdatetime(Date userdatetime) {
        this.userdatetime = userdatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirth=" + userBirth +
                ", userEmail='" + userEmail + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userIDCard='" + userIDCard + '\'' +
                ", userdatetime=" + userdatetime +
                '}';
    }
}