package com.example.contentprovidertest;

public class FunkoPopData {
    private int id;
    private String popName;
    private int popNumber;
    private String popType;
    private String fandom;
    private boolean on;
    private String ultimate;
    private double price;

    public FunkoPopData(int id, String popName, int popNumber, String popType, String fandom, boolean on, String ultimate, double price) {
        this.id = id;
        this.popName = popName;
        this.popNumber = popNumber;
        this.popType = popType;
        this.fandom = fandom;
        this.on = on;
        this.ultimate = ultimate;
        this.price = price;
    }

    public String getName() {
        return popName;
    }

    public void setName(String name){
        popName = name;
    }

    public int getNumber() {
        return popNumber;
    }

    public void setNumber(int number){
        popNumber = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPopType() {
        return popType;
    }

    public void setPopType(String popType) {
        this.popType = popType;
    }

    public String getFandom() {
        return fandom;
    }

    public void setFandom(String fandom) {
        this.fandom = fandom;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getUltimate() {
        return ultimate;
    }

    public void setUltimate(String ultimate) {
        this.ultimate = ultimate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
