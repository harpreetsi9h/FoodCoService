package com.happydev.FoodCoService.order.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteOrderCommand {

    @TargetAggregateIdentifier
    private String deleteOrderId;
    private String orderId;
}
