package com.happydev.FoodCoService.customer;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public String saveCustomer(Customer address) {
        address.setCustomerId(UUID.randomUUID().toString());
        repository.save(address);
        return address.getCustomerId();
    }

    public String removeCustomer(String addressId) throws CustomMessageException {
        if (repository.findById(addressId).isPresent()) {
            repository.deleteById(addressId);
            return Constants.CUSTOMER_REMOVED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+addressId);

    }

    public Customer getCustomer(String addressId) throws CustomMessageException {
        if(repository.findById(addressId).isEmpty())
            throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+addressId);
        return repository.findById(addressId).get();
    }

    public String updateCustomer(Customer address) throws CustomMessageException {

        if (repository.findById(address.getCustomerId()).isPresent()) {
            repository.save(address);
            return Constants.CUSTOMER_UPDATED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.CUSTOMER_NOT_FOUND_WITH_ID+address.getCustomerId());

    }
}
