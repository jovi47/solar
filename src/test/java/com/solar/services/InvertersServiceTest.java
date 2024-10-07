package com.solar.services;

import com.solar.entities.Fabricator;
import com.solar.entities.Inverter;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertersServiceTest {
    private static InvertersService invertersService;
    private static Fabricator fabricator;
    private static final String FILE_PATH = "test_invester.json";

    @BeforeAll
    static void setUpAll() {
        fabricator = new Fabricator("Fabricator A");
        invertersService = new InvertersService(FILE_PATH);
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
        Inverter inverter = new Inverter(fabricator, "ZT-SOLAR", 2000, 3000);
        invertersService.save(inverter);

        File file = new File(FILE_PATH);

        assertNotNull(file);
    }

    @Test
    void testFindAll() {
        Inverter inverter = new Inverter(fabricator, "BA-SOLAR01", 2300, 4000);
        invertersService.save(inverter);

        Inverter inverter2 = new Inverter(fabricator, "BA-T5000", 4000, 7000);
        invertersService.save(inverter2);

        List<Inverter> inverters = invertersService.findAll();

        assertNotNull(inverters);
        assertEquals(2, inverters.size());
        assertEquals("BA-SOLAR01", inverters.get(0).getModel());
        assertEquals("BA-T5000", inverters.get(1).getModel());
    }

    @Test
    void testSaveFailure() {
        Inverter inverter = new Inverter(fabricator, "ITA_ZT01", 3500, 5000);
        invertersService.save(inverter);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            invertersService.save(inverter);
        });

        assertEquals(exception.getMessage(), "Inverter already exists");
    }
}