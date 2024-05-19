package com.happydev.FoodCoService.order.core.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    private String orderId;
    private String updateOrderId;
    @NotBlank
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;
}
