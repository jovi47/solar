package com.solar.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelTest {
    private SolarPanel solarPanel;
    private Fabricator fabricator;

    @BeforeEach
    void setUp() {
        fabricator = new Fabricator("Fabricator C");
        solarPanel = new SolarPanel(fabricator, "PS-08", 5000,7000,8);
    }

    @Test
    void testSolarPanelEqualsByModel() {
        SolarPanel newSolarPanel = new SolarPanel(fabricator, "S-5000", 2000, 3000, 5);
        assertNotEquals(solarPanel, newSolarPanel);

        newSolarPanel.setModel(solarPanel.getModel());
        assertEquals(solarPanel, newSolarPanel);
    }

    @Test
    public void testUpdateSolarPanelFieldsWithValidData() {
        solarPanel.setFabricatorName("UFS-Solar");
        assertEquals("UFS-Solar", solarPanel.getFabricatorName());
        solarPanel.setModel("UZT-500");
        assertEquals("UZT-500", solarPanel.getModel());
        solarPanel.setPotency(5500);
        assertEquals(5500, solarPanel.getPotency());
        solarPanel.setPrice(6000);
        assertEquals(6000, solarPanel.getPrice());
        solarPanel.setCapacity(6);
        assertEquals(6, solarPanel.getCapacity());
        solarPanel.setFabricatorName("");
        assertEquals("",solarPanel.getFabricatorName());
        solarPanel.setPotency(0);
        assertEquals(0, solarPanel.getPotency());
    }
}