package com.example;

import java.util.Calendar;

public class User {

    private String name;

    private Calendar passwdExpirationDate;

    public User(String name) {
        this.name = name;
        this.passwdExpirationDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getPasswdExpirationDate() {
        return passwdExpirationDate;
    }

    public void setPasswdExpirationDate(Calendar passwdExpirationDate) {
        this.passwdExpirationDate = passwdExpirationDate;
    }

}
