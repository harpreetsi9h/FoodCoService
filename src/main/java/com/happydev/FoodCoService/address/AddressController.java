package com.happydev.FoodCoService.address;

import com.happydev.FoodCoService.exception.CustomMessageException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok(addressService.getAddresses());
    }

    @PostMapping("/address")
    public ResponseEntity<String> addAddress(@RequestBody @Valid Address address) {
        String addressId = addressService.saveAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressId);
    }

    @GetMapping("/address/id={addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable String addressId) throws CustomMessageException {
        return ResponseEntity.ok(addressService.getAddress(addressId));
    }

    @DeleteMapping("/address/id={addressId}")
    public ResponseEntity<String> removeAddress(@PathVariable String addressId) throws CustomMessageException {
        addressService.removeAddress(addressId);
        return ResponseEntity.ok("Address Removed Successfully!");
    }

    @PutMapping("/address")
    public ResponseEntity<String> updateAddress(@RequestBody Address address) throws CustomMessageException {
        addressService.updateAddress(address);
        return ResponseEntity.ok("Address Updated Successfully!");
    }
}
