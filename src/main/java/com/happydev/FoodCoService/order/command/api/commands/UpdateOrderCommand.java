package com.happydev.FoodCoService.order.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateOrderCommand {

    @TargetAggregateIdentifier
    private String updateOrderId;
    private String orderId;
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;

}
