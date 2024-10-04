package com.solar.services;

import com.solar.entities.Customer;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Database<Customer> {

    private final String filePath;

    public CustomerService() {
        filePath = "src/database/customers.json";
    }

    public CustomerService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Customer customer) {
        List<Customer> customers = findAll();
        if (customers == null) {
            customers = new ArrayList<>();
        }

        System.out.println(customers.size());
        if (!customers.contains(customer)) {
            customers.add(customer);
        } else {
            throw new RuntimeException("Customer already exists");
        }

        saveOnFile(filePath, customers);
    }

    @Override
    public List<Customer> findAll() {
        Type customerListType = new TypeToken<List<Customer>>() {
        }.getType();
        return findAllOnFile(filePath, customerListType);
    }

}
