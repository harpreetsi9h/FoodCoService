package com.happydev.FoodCoService.orderItem.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemCreatedEvent {
    private String orderItemId;
    private String menuItemId;
    private Integer quantity;
}
