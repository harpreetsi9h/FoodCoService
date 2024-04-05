package com.happydev.FoodCoService.customer;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public String createCustomer(Customer customer) {
        customer.setCustomerId(UUID.randomUUID().toString());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        customer.setCreatedAt(timestamp.toString());
        repository.save(customer);
        return customer.getCustomerId();
    }

    public String removeCustomer(String customerId) throws CustomMessageException {
        if (repository.findById(customerId).isPresent()) {
            repository.deleteById(customerId);
            return Constants.CUSTOMER_REMOVED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+customerId);

    }

    public Customer getCustomer(String customerId) throws CustomMessageException {
        if(repository.findById(customerId).isEmpty())
            throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+customerId);
        return repository.findById(customerId).get();
    }

    public String updateCustomer(Customer customer) throws CustomMessageException {

        if (repository.findById(customer.getCustomerId()).isPresent()) {
            repository.save(customer);
            return Constants.CUSTOMER_UPDATED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+customer.getCustomerId());

    }
}
