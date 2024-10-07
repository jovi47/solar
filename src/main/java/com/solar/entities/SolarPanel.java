package com.solar.entities;

import java.util.Objects;

public class SolarPanel{
    private Fabricator fabricator;
    private String model;
    private int potency;
    private double price;
    private int capacity;

    public SolarPanel(Fabricator fabricator, String model, int potency, double price, int capacity) {
        this.fabricator = fabricator;
        this.model = model;
        this.potency = potency;
        this.price = price;
        this.capacity = capacity;
    }

    public String getFabricatorName() {
        return fabricator.getName();
    }

    public void setFabricatorName (String fabricatorName) {
        fabricator.setName(fabricatorName);
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanel solarPanel = (SolarPanel) o;
        return Objects.equals(getModel(), solarPanel.getModel());
    }
}