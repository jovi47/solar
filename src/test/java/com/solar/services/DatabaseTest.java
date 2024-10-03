package com.solar.services;

import com.google.gson.reflect.TypeToken;
import com.solar.entities.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private static final String FILE_PATH = "test.json";
    private static Database<Customer> database;


    @BeforeAll
    static void setUpAll() {
        database = new Database<Customer>() {
            @Override
            public void save(Customer data) {
                System.out.println(data);
            }

            @Override
            public List<Customer> findAll() {
                return null;
            }
        };
    }

    @BeforeEach
    void setUp() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
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
    void testSaveOnFile() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", "123456789", "555-1234", "123 Elm St"));

        database.saveOnFile(FILE_PATH, customers);

        File file = new File(FILE_PATH);

        assertNotNull(file);
    }

    @Test
    void testSaveOnFileFailure() {
        assertThrows(RuntimeException.class, () -> {
            database.saveOnFile("/invalid_path/customers.json", List.of(new Customer("John Doe", "123456789", "555-1234", "123 Elm St")));
        });
    }


    @Test
    void testFindAllOnFile() {
        Type customerListType = new TypeToken<List<Customer>>() {
        }.getType();

        List<Customer> customers = database.findAllOnFile(FILE_PATH, customerListType);

        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals("John Doe", customers.getFirst().getName());
    }

    @Test
    void testFindAllOnFileFailure() {

        String invalidFilePath = "/invalid_path/customers.json";
        Type customerListType = new TypeToken<List<Customer>>() {
        }.getType();

        assertNull(database.findAllOnFile("/invalid_path/customers.json", customerListType));
    }
}