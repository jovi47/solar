package com.solar.services;

import com.solar.entities.Equipment;
import com.google.gson.reflect.TypeToken;
import com.solar.entities.Inverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InvertersService implements Database<Inverter> {
    private final String filePath;

    public InvertersService() {
        filePath = "src/database/inverters.json";
    }

    @Override
    public void save(Inverter inverter) {
        List<Inverter> inverters = findAll();
        if (inverters == null) {
            inverters = new ArrayList<>();
        }

        System.out.println(inverters.size());

        if (!inverters.contains(inverter)) {
            inverters.add(inverter);
        } else {
            throw new RuntimeException("Customer already exists");
        }

        saveOnFile(filePath, inverters);

    }

    @Override
    public List<Inverter> findAll() {
        Type inverterListType = new TypeToken<List<Inverter>>() {
        }.getType();
        return findAllOnFile(filePath, inverterListType);
    }
}