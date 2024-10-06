package com.solar.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelTest {
    private SolarPanel solarPanel;

    @BeforeEach
    void setUp() {
        solarPanel = new SolarPanel("Mundo das Placas", "PS-08", 5000,7000,8);
    }

    @Test
    void testSolarPanelEqualsByModel() {
        SolarPanel newSolarPanel = new SolarPanel("Solar SE", "S-5000", 2000, 3000, 5);
        assertNotEquals(solarPanel, newSolarPanel);

        newSolarPanel.setModel(solarPanel.getModel());
        assertEquals(solarPanel, newSolarPanel);
    }

    @Test
    public void testUpdateSolarPanelFieldsWithValidData() {
        solarPanel.setfabricator("UFS-Solar");
        assertEquals("UFS-Solar", solarPanel.getfabricator());
        solarPanel.setModel("UZT-500");
        assertEquals("UZT-500", solarPanel.getModel());
        solarPanel.setPotency(5500);
        assertEquals(5500, solarPanel.getPotency());
        solarPanel.setPrice(6000);
        assertEquals(6000, solarPanel.getPrice());
        solarPanel.setCapacity(6);
        assertEquals(6, solarPanel.getCapacity());
        solarPanel.setfabricator("");
        assertEquals("",solarPanel.getfabricator());
        solarPanel.setPotency(0);
        assertEquals(0, solarPanel.getPotency());
    }
}