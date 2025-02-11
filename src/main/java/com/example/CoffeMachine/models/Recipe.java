package com.example.CoffeMachine.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(6, 2)")
    private Double coffee;

    @Column(nullable = false, columnDefinition = "DECIMAL(6, 2)")
    private Double milk;

    @Column(nullable = false, columnDefinition = "DECIMAL(6, 2)")
    private Double water;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    @JsonManagedReference
    private List<Product> products; 
    
    public Recipe() { }

    public Recipe(String name, Double coffee, Double milk, Double water) {
        this.name = name;
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
    }

    public Recipe(String name, Double coffee, Double milk, Double water, List<Product> products) {
        this.name = name;
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
        this.products = products;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCoffee() {
        return this.coffee;
    }

    public void setCoffee(Double coffe) {
        this.coffee = coffe;
    }

    public Double getMilk() {
        return this.milk;
    }

    public void setMilk(Double milk) {
        this.milk = milk;
    }

    public Double getWater() {
        return this.water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
