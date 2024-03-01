package com.happydev.FoodCoService.restaurant;

import com.happydev.FoodCoService.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReponseModel {
    private String restId;
    private String name;
    private String cuisine;
    private Float rating;
    private Address address;
    private String openingTime;
    private String closingTime;
    private String logoPic;
    private String coverPic;
}
