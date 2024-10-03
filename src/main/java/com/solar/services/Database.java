package com.solar.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.solar.entities.Customer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface Database<T> {

    static final Gson gson = new Gson();

    public void save(T data);

    default void saveOnFile(String filePath, List<T> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> findAll();

    default List<T> findAllOnFile(String filePath, Type dataListType) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, dataListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
