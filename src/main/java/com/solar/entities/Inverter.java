package com.solar.entities;

import java.util.Objects;

public class Inverter {
    private Fabricator fabricator;
    private String model;
    private int potency;
    private double price;

    public Inverter(Fabricator fabricator, String model, int potency, double price) {
        this.fabricator = fabricator;
        this.model = model;
        this.potency = potency;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inverter inverter = (Inverter) o;
        return Objects.equals(getModel(), inverter.getModel());
    }
}
