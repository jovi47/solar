package com.solar.services;

import com.solar.entities.SolarPanel;
import com.solar.entities.Fabricator;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelServiceTest {
    private static SolarPanelService solarPanelService;
    private static Fabricator fabricator;
    private static final String FILE_PATH = "test_solar_panel.json";

    @BeforeAll
    static void setUpAll() {
        fabricator = new Fabricator("Fabricator A");
        solarPanelService = new SolarPanelService(FILE_PATH);
    }

    @BeforeEach
    void setUp() {
        File file = new File(FILE_PATH);
        if(file.exists()) {
            file.delete();
        }
    }
    @AfterAll
    static void tearDown() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSave() {
        SolarPanel solarPanel = new SolarPanel(fabricator, "SUN-ZT01", 5000, 7000,8);
        solarPanelService.save(solarPanel);

        File file = new File(FILE_PATH);

        assertNotNull(file);
    }

    @Test
    void testFindAll() {
        SolarPanel solarPanel = new SolarPanel(fabricator, "ITA-SOLAR01", 2500, 3000,4);
        solarPanelService.save(solarPanel);

        SolarPanel solarPanel2 = new SolarPanel(fabricator, "ITA-SOLAR05", 7500, 10500,8);
        solarPanelService.save(solarPanel2);

        List<SolarPanel> solarPanels = solarPanelService.findAll();

        assertNotNull(solarPanels);
        assertEquals(2, solarPanels.size());
        assertEquals("ITA-SOLAR01", solarPanels.get(0).getModel());
        assertEquals("ITA-SOLAR05", solarPanels.get(1).getModel());
    }

    @Test
    void testSaveFailure() {
        SolarPanel solarPanel = new SolarPanel(fabricator, "ITA-SOLAR04", 4500, 4000,5);
        solarPanelService.save(solarPanel);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            solarPanelService.save(solarPanel);
        });

        assertEquals(exception.getMessage(), "Solar Panel already exists");
    }

}