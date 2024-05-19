package com.happydev.FoodCoService.order.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeletedEvent {

    private String deleteOrderId;
    private String orderId;
}
