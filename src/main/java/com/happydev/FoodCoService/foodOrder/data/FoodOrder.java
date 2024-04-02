package com.happydev.FoodCoService.foodOrder.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
public class FoodOrder {

    @Id
    private String orderId;
    @NotBlank
    private String customerId;
    @NotBlank
    private String restId;
    @NotBlank
    private String customerAddressId;
    @NotBlank
    private String driverId;
    @NotBlank
    private List<String> orderMenuItems;
    @NotBlank
    private String orderDateTime;
    @NotBlank
    private String deliveryFee;
    @NotBlank
    private String serviceFee;
    @NotBlank
    private String totalAmount;
    private String orderStatus;
}
