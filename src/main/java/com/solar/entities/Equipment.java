package com.solar.entities;

public class Equipment {
    private String fabricator;
    private String model;
    private int potency;
    private double price;

    public Equipment(String fabricator, String model, int potency, double price) {
        this.fabricator = fabricator;
        this.model = model;
        this.potency = potency;
        this.price = price;
    }

    public String getfabricator() {
        return fabricator;
    }

    public void setfabricator(String fabricator) {
        this.fabricator = fabricator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}