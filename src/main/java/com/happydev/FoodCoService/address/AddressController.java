package com.happydev.FoodCoService.address;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        String addressId = addressService.saveAddress(address);
        return ResponseEntity.ok(addressId);
    }

    @GetMapping("/address/id={addressId}")
    ResponseEntity<Address> getAddress(@PathVariable String addressId) {
        return ResponseEntity.ok(addressService.getAddress(addressId));
    }

    @DeleteMapping("/address/id={addressId}")
    public ResponseEntity<String> removeAddress(@PathVariable String addressId) {
        addressService.removeAddress(addressId);
        return ResponseEntity.ok("Address Removed Successfully!");
    }
}
