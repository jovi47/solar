package com.solar.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverterTest {
    private Inverter inverter;
    private Fabricator fabricator;

    @BeforeEach
    void setUp() {
        fabricator = new Fabricator("Fabricator B");
        inverter = new Inverter(fabricator, "Sun-XT01", 4000, 2500);
    }

    @Test
    public void testInverterEqualsByModel() {
        Inverter newInverter = new Inverter(fabricator, "XT_Sun0978", 5000, 3000);
        assertNotEquals(inverter, newInverter);

        newInverter.setModel(inverter.getModel());
        assertEquals(inverter, newInverter);
    }

    @Test
    public void testUpdateInverterFieldsWithValidData() {
        inverter.setFabricatorName("UFS-Solar");
        assertEquals("UFS-Solar", inverter.getFabricatorName());
        inverter.setModel("UZT-500");
        assertEquals("UZT-500", inverter.getModel());
        inverter.setPotency(5500);
        assertEquals(5500, inverter.getPotency());
        inverter.setPrice(6000);
        assertEquals(6000, inverter.getPrice());
        inverter.setFabricatorName("");
        assertEquals("",inverter.getFabricatorName());
        inverter.setPotency(0);
        assertEquals(0, inverter.getPotency());
    }

}
