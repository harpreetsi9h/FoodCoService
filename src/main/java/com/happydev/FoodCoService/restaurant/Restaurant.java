package com.happydev.FoodCoService.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String restId;
    private String name;
    private String cuisine;
    private Float rating;
    private String addressId;
    private String openingTime;
    private String closingTime;
    private String logoPic;
    private String coverPic;
}
