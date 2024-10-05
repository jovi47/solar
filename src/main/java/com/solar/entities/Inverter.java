package com.solar.entities;

import java.util.Objects;

public class Inverter extends Equipment{

    public Inverter(String fabricator, String model, int potency, double price) {
        super(fabricator, model, potency, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inverter inverter = (Inverter) o;
        return Objects.equals(super.getModel(), Inverter.super.getModel());
    }
}
