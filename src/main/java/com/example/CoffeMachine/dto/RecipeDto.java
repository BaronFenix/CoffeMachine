package com.example.CoffeMachine.dto;

public class RecipeDto {

    private String Name;

    private Double price;

    private Double size;

    private double coffee;

    private double milk;

    private double water;


    public RecipeDto() {}

    public RecipeDto(String Name, Double price, Double size, double coffee, double milk, double water) {
        this.Name = Name;
        this.price = price;
        this.size = size;
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return this.size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public double getCoffee() {
        return this.coffee;
    }

    public void setCoffee(double coffee) {
        this.coffee = coffee;
    }

    public double getMilk() {
        return this.milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public double getWater() {
        return this.water;
    }

    public void setWater(double water) {
        this.water = water;
    }



}
