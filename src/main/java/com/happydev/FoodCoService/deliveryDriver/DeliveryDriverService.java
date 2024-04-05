package com.happydev.FoodCoService.deliveryDriver;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryDriverService {

    private final DeliveryDriverRepository repository;

    @Autowired
    public DeliveryDriverService(DeliveryDriverRepository repository) {
        this.repository = repository;
    }

    public List<DeliveryDriver> getDeliveryDrivers() {
        return repository.findAll();
    }

    public String createDeliveryDriver(DeliveryDriver deliveryDriver) {
        deliveryDriver.setDriverId(UUID.randomUUID().toString());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        deliveryDriver.setCreatedAt(timestamp.toString());
        repository.save(deliveryDriver);
        return deliveryDriver.getDriverId();
    }

    public String removeDeliveryDriver(String driverId) throws CustomMessageException {
        if (repository.findById(driverId).isPresent()) {
            repository.deleteById(driverId);
            return Constants.DELIVERY_DRIVER_REMOVED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.DRIVER_NOT_FOUND_WITH_ID+driverId);

    }

    public DeliveryDriver getDeliveryDriver(String driverId) throws CustomMessageException {
        if(repository.findById(driverId).isEmpty())
            throw new CustomMessageException(Constants.DRIVER_NOT_FOUND_WITH_ID+driverId);
        return repository.findById(driverId).get();
    }

    public String updateDeliveryDriver(DeliveryDriver deliveryDriver) throws CustomMessageException {

        if (repository.findById(deliveryDriver.getDriverId()).isPresent()) {
            repository.save(deliveryDriver);
            return Constants.DELIVERY_DRIVER_UPDATED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.DRIVER_NOT_FOUND_WITH_ID+deliveryDriver.getDriverId());

    }
}
