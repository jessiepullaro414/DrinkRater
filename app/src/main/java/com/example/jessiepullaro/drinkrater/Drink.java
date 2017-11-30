package com.example.jessiepullaro.drinkrater;

/**
 * Created by jessie on 11/30/17.
 */

public class Drink {
    private String drinkType, drinkName;
    private Double ABV;

    public Drink (String drinkType, String drinkName, Double ABV){
        this.drinkType = drinkType;
        this.drinkName = drinkName;
        this.ABV = ABV;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Double getABV() {
        return ABV;
    }

    public void setABV(Double ABV) {
        this.ABV = ABV;
    }
}
