package com.example.jessiepullaro.drinkrater;

/**
 * Created by jessie on 11/30/17.
 */

public class Rating {
    private int rating;
    private String drinkName, username, description;

    public Rating(String drinkName, String username, int rating, String description) {
        this.drinkName = drinkName;
        this.username = username;
        this.rating = rating;
        this.description = description;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
