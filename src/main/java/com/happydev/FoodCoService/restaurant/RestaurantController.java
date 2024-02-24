package com.happydev.FoodCoService.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurant")
    public ResponseEntity<List<RestaurantReponseModel>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PostMapping("/restaurant")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
        String restId = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(restId);
    }

    @GetMapping("/restaurant/id={restId}")
    ResponseEntity<RestaurantReponseModel> getRestaurant(@PathVariable String restId) {
        return ResponseEntity.ok(restaurantService.getRestaurant(restId));
    }

    @DeleteMapping("/restaurant/id={restId}")
    public ResponseEntity<String> removeRestaurant(@PathVariable String restId) {
        restaurantService.removeRestaurant(restId);
        return ResponseEntity.ok("Restaurant Removed Successfully!");
    }
}
