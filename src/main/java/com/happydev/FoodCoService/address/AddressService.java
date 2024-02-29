package com.happydev.FoodCoService.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAddresses() {
        return repository.findAll();
    }

    public String saveAddress(Address address) {
        address.setAddressId(UUID.randomUUID().toString());
        repository.save(address);
        return address.getAddressId();
    }

    public void removeAddress(String addressId) {
        repository.deleteById(addressId);
    }

    public Address getAddress(String addressId) {
        return repository.findAll().stream()
                .filter(
                        address -> address.getAddressId()
                                .equals(addressId)
                ).findFirst()
                .orElse(null);
    }

    public boolean updateAddress(Address address) {

        boolean result;

        if (repository.findById(address.getAddressId()).isPresent()) {
            repository.save(address);
            result = true;
        }
        else result = false;

        return result;
    }
}
