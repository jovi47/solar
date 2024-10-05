package com.solar.services;

import com.solar.entities.Equipment;
import com.google.gson.reflect.TypeToken;
import com.solar.entities.Inverter;
import com.solar.entities.SolarPanel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SolarPanelService implements Database<SolarPanel> {
    private final String filePath;

    public SolarPanelService() {
        filePath = "src/database/solar-panels.json";
    }

    @Override
    public void save(SolarPanel solarPanel) {
        List<SolarPanel> solarPanels = findAll();
        if (solarPanels == null) {
            solarPanels = new ArrayList<>();
        }

        System.out.println(solarPanels.size());

        if (!solarPanels.contains(solarPanel)) {
            solarPanels.add(solarPanel);
        } else {
            throw new RuntimeException("Customer already exists");
        }

        saveOnFile(filePath, solarPanels);

    }

    @Override
    public List<SolarPanel> findAll() {
        Type solarPanelListType = new TypeToken<List<SolarPanel>>() {
        }.getType();
        return findAllOnFile(filePath, solarPanelListType);
    }
}