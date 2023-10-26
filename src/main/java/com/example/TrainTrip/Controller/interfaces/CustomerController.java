package com.example.TrainTrip.Controller.interfaces;

import com.example.TrainTrip.Entity.Customer;

import java.util.List;

public interface CustomerController {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long customerId);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long customerId, Customer customer);
    void deleteCustomer(Long customerId);
}
