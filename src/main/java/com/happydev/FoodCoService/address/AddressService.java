package com.happydev.FoodCoService.address;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
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

    public void removeAddress(String addressId) throws CustomMessageException {
        if (repository.findById(addressId).isPresent())
            repository.deleteById(addressId);
        else throw new CustomMessageException(Constants.ADDRESS_NOT_FOUND_WITH_ID+addressId);
    }

    public Address getAddress(String addressId) throws CustomMessageException {
        return repository.findAll().stream()
                .filter(
                        address -> address.getAddressId()
                                .equals(addressId)
                ).findFirst()
                .orElseThrow(() -> new CustomMessageException(Constants.ADDRESS_NOT_FOUND_WITH_ID+addressId));
    }

    public void updateAddress(Address address) throws CustomMessageException {

        if (repository.findById(address.getAddressId()).isPresent())
            repository.save(address);
        else throw new CustomMessageException(Constants.ADDRESS_NOT_FOUND_WITH_ID+address.getAddressId());

    }
}
