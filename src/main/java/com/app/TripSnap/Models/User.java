package com.app.TripSnap.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private long userId;

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private boolean admin=false;
    private String userName;
    private String userEmail;
    private int userAge;

    public User(long userId, String userName, String userEmail, int userAge, String userGender, String userPassword,boolean admin) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userPassword = userPassword;
        this.admin=admin;
    }

    private String userGender;
    private String userPassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
