package com.happydev.FoodCoService.order.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdatedEvent {

    private String orderId;
    private String updateOrderId;
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;
}
