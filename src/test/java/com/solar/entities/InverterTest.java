package com.solar.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverterTest {
    private Inverter inverter;

    @BeforeEach
    void setUp() {
        inverter = new Inverter("Inversor SA", "Sun-XT01", 4000, 2500);
    }

    @Test
    public void testInverterEqualsByModel() {
        Inverter newInverter = new Inverter("Inversor-XT", "XT_Sun0978", 5000, 3000);
        assertNotEquals(inverter, newInverter);

        newInverter.setModel(inverter.getModel());
        assertEquals(inverter, newInverter);
    }

    @Test
    public void testUpdateInverterFieldsWithValidData() {
        inverter.setfabricator("UFS-Solar");
        assertEquals("UFS-Solar", inverter.getfabricator());
        inverter.setModel("UZT-500");
        assertEquals("UZT-500", inverter.getModel());
        inverter.setPotency(5500);
        assertEquals(5500, inverter.getPotency());
        inverter.setPrice(6000);
        assertEquals(6000, inverter.getPrice());
        inverter.setfabricator("");
        assertEquals("",inverter.getfabricator());
        inverter.setPotency(0);
        assertEquals(0, inverter.getPotency());
    }

}
