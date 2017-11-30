package com.example.jessiepullaro.drinkrater;

/**
 * Created by jessie on 11/30/17.
 */

public class User {
    private String email, passHash;

    public User (String email, String passHash){
        this.email = email;
        this.passHash = passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
