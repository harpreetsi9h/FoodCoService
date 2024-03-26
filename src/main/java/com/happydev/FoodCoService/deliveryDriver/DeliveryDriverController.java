package com.happydev.FoodCoService.deliveryDriver;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(Constants.URL_API)
public class DeliveryDriverController {

    private final DeliveryDriverService service;

    @Autowired
    public DeliveryDriverController(DeliveryDriverService service) {
        this.service = service;
    }

    @GetMapping(Constants.URL_DELIVERY_DRIVER)
    public ResponseEntity<List<DeliveryDriver>> getDeliveryDrivers() {
        return ResponseEntity.ok(service.getDeliveryDrivers());
    }

    @PostMapping(Constants.URL_DELIVERY_DRIVER)
    public ResponseEntity<String> addDeliveryDriver(@RequestBody @Valid DeliveryDriver driver) {
        String driverId = service.saveDeliveryDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverId);
    }

    @GetMapping(Constants.URL_DELIVERY_DRIVER+"/{driverId}")
    public ResponseEntity<DeliveryDriver> getDeliveryDriver(@PathVariable String driverId) throws CustomMessageException {
        return ResponseEntity.ok(service.getDeliveryDriver(driverId));
    }

    @DeleteMapping(Constants.URL_DELIVERY_DRIVER+"/{driverId}")
    public ResponseEntity<String> removeDeliveryDriver(@PathVariable String driverId) throws CustomMessageException {
        return ResponseEntity.ok(service.removeDeliveryDriver(driverId));
    }

    @PutMapping(Constants.URL_DELIVERY_DRIVER)
    public ResponseEntity<String> updateDeliveryDriver(@RequestBody @Valid DeliveryDriver driver) throws CustomMessageException {
        return ResponseEntity.ok(service.updateDeliveryDriver(driver));
    }
}
