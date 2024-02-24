package com.happydev.FoodCoService.restaurant;

import com.happydev.FoodCoService.util.InternalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;
    private final InternalServices internalServices;

    @Autowired
    public RestaurantService(RestaurantRepository repository, InternalServices internalServices) {
        this.repository = repository;
        this.internalServices = internalServices;
    }

    public String saveRestaurant(Restaurant restaurant) {
        String restId = UUID.randomUUID().toString();
        restaurant.setRestId(restId);
        repository.save(restaurant);
        return restId;
    }

    public void removeRestaurant(String restId) {
        repository.deleteById(restId);
    }

    public List<RestaurantReponseModel> getAllRestaurants() {
        List<Restaurant> dataList = repository.findAll();

        return dataList.stream().map(
        data -> RestaurantReponseModel.builder()
                .restId(data.getRestId())
                .name(data.getName())
                .address(internalServices.getAddress(data.getAddressId()))
                .closingTime(data.getClosingTime())
                .openingTime(data.getOpeningTime())
                .coverPic(data.getCoverPic())
                .logoPic(data.getLogoPic())
                .build()
        ).collect(Collectors.toList());
    }

    public RestaurantReponseModel getRestaurant(String restId) {
        Restaurant data = repository.findAll().stream()
                .filter(
                        restaurant -> restaurant.getRestId()
                                .equals(restId)
                ).findFirst()
                .orElse(null);

        if (data==null)
            return null;

        return new RestaurantReponseModel().builder()
                .restId(data.getRestId())
                .name(data.getName())
                .address(internalServices.getAddress(data.getAddressId()))
                .closingTime(data.getClosingTime())
                .openingTime(data.getOpeningTime())
                .coverPic(data.getCoverPic())
                .logoPic(data.getLogoPic())
                .build();
    }

}
