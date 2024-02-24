package com.happydev.FoodCoService.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String addressId;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String postalCode;

}
