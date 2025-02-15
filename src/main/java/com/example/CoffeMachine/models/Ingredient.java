package com.example.CoffeMachine.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(8, 2)")
    private Double value;

    @Column(nullable = false, columnDefinition = "DECIMAL(8, 2)")
    private Double maxLimit;

    public Ingredient() {}


    public Ingredient(String name, Double value, Double maxLimit) {
        this.name = name;
        this.value = value;
        this.maxLimit = maxLimit;
    }


    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getMaxLimit() {
        return this.maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }
    


}
