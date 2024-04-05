package com.happydev.FoodCoService.orderItem.command.api.commands;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateOrderItemCommand {

    @TargetAggregateIdentifier
    private String orderItemId;
    private String menuItemId;
    private Integer quantity;
}
