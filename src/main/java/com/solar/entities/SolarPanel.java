package com.solar.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanel solarPanel = (SolarPanel) o;
        return Objects.equals(super.getModel(), solarPanel.getModel());
    }
}