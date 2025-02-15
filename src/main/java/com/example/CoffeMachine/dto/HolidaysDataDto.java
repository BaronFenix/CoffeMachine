package com.example.CoffeMachine.dto;

import java.util.ArrayList;

public class HolidaysDataDto {
    private String date;

    private String localName;

    private String name;

    private String countryCode;

    private boolean fixed;

    private boolean global;

    private Object counties;

    private Object launchYear;

    private ArrayList<String> types;

    public HolidaysDataDto() {}

    public HolidaysDataDto(String date, String localName, String name, String countryCode, boolean fixed, boolean global, Object counties, Object launchYear, ArrayList<String> types) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.types = types;
    }


    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return this.localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public boolean getFixed() {
        return this.fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isGlobal() {
        return this.global;
    }

    public boolean getGlobal() {
        return this.global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public Object getCounties() {
        return this.counties;
    }

    public void setCounties(Object counties) {
        this.counties = counties;
    }

    public Object getLaunchYear() {
        return this.launchYear;
    }

    public void setLaunchYear(Object launchYear) {
        this.launchYear = launchYear;
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

}
