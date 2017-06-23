package com.smarthome.mybatis.dto;

import com.smarthome.mybatis.po.User;

import java.util.Date;

public class UserDTO {
    private Integer userId;

    private String userType;

    private String userName;

    private String userSex;

    private Date userBirth;

    private String userEmail;

    private String userTel;

    private String userIDCard;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userType = user.getUserType();
        this.userName = user.getUserName();
        this.userSex = user.getUserSex();
        this.userBirth = user.getUserBirth();
        this.userEmail = user.getUserEmail();
        this.userTel = user.getUserTel();
        this.userIDCard = user.getUserIDCard();
    }

    public UserDTO(Integer userId, String userType, String userName, String userSex, Date userBirth, String userEmail, String userTel, String userIDCard) {
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.userIDCard = userIDCard;
    }

    public UserDTO() {
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
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
}