package com.example.jessiepullaro.drinkrater;

/**
 * Created by jessie on 11/30/17.
 */

public class User {
    private String username, passHash;

    public User (String username, String passHash){
        this.username = username;
        this.passHash = passHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
