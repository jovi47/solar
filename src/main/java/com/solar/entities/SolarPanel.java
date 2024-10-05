package com.solar.entities;

public class SolarPanel extends Equipment {
    private int capacity;

    public SolarPanel(String fabricator, String model, int potency, double price, int capacity) {
        super(fabricator, model, potency, price);
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}