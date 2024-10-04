package com.solar.services;

import com.google.gson.reflect.TypeToken;
import com.solar.entities.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private static CustomerService customerService;
    private static final String FILE_PATH = "test_customer.json";

    @BeforeAll
    static void setUpAll() {
        customerService = new CustomerService(FILE_PATH);
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
    void testSave() {
        Customer customer = new Customer("John Doe", "409.742.650-80", "11982379090", "123 Elm St");
        customerService.save(customer);

        File file = new File(FILE_PATH);

        assertNotNull(file);
    }

    @Test
    void testSaveFailure() {
        Customer customer = new Customer("John Doe", "409.742.650-80", "11982379090", "123 Elm St");
        customerService.save(customer);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            customerService.save(customer);
        });

        assertEquals(exception.getMessage(), "Customer already exists");
    }

    @Test
    void testFindAll() {
        Customer customer = new Customer("John Doe", "409.742.650-80", "11982379090", "123 Elm St");
        customerService.save(customer);

        Customer customer2 = new Customer("Ryan Doe", "409.742.650-70", "11982379090", "123 Elm St");
        customerService.save(customer2);

        List<Customer> customers = customerService.findAll();

        assertNotNull(customers);
        assertEquals(2, customers.size());
        assertEquals("John Doe", customers.get(0).getName());
        assertEquals("Ryan Doe", customers.get(1).getName());
    }
}
