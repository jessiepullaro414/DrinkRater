package com.example.jessiepullaro.drinkrater;

/**
 * Created by jessie on 11/30/17.
 */

public class Rating {
    private int rating;
    private String description;

    public Rating(int rating, String description) {
        this.rating = rating;
        this.description = description;
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
