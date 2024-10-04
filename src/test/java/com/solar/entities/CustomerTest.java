package com.solar.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "140.532.600-00", "79987629872", "Rua Cinco 44 Jabotiana 78");
    }

    @Test
    public void testCreateCustomerWithValidData() {
        assertNotNull(customer);
        assertEquals("John", customer.getName());
        assertEquals("140.532.600-00", customer.getDocument());
        assertEquals("79987629872", customer.getPhoneNumber());
        assertEquals("Rua Cinco 44 Jabotiana 78", customer.getAddress());
    }

    @Test
    public void testUpdateCustomerFieldsWithValidData() {
        customer.setName("Ryan");
        assertEquals("Ryan", customer.getName());
        customer.setDocument("446.817.950-38");
        assertEquals("446.817.950-38", customer.getDocument());
        customer.setPhoneNumber("79987528736");
        assertEquals("79987528736", customer.getPhoneNumber());
        customer.setAddress("Rio de Janeiro Brasil");
        assertEquals("Rio de Janeiro Brasil", customer.getAddress());
    }

    @Test
    public void testCustomerEqualsByDocument() {
        Customer customer2 = new Customer("Dembryt", "242.395.740-80", "21999238721", "Casa da barra da mamae Joana");
        assertFalse(customer.equals(customer2));
        
        customer2.setDocument(customer.getDocument());
        assertTrue(customer.equals(customer2));
    }
}
