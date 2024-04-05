package com.happydev.FoodCoService.orderItem.command.api.controller;

import com.happydev.FoodCoService.orderItem.command.api.commands.CreateOrderItemCommand;
import com.happydev.FoodCoService.orderItem.core.model.OrderItemModel;
import com.happydev.FoodCoService.util.Constants;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(Constants.URL_API)
public class OrderItemCommandController {

    private final CommandGateway commandGateway;

    public OrderItemCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(Constants.URL_ORDER_ITEM)
    public ResponseEntity<String> addOrderItem(@RequestBody @Valid OrderItemModel orderItem) {
        CreateOrderItemCommand createOrderItemCommand = CreateOrderItemCommand.builder()
                .orderItemId(UUID.randomUUID().toString())
                .menuItemId(orderItem.getMenuItemId())
                .quantity(orderItem.getQuantity())
                .build();

        String result = commandGateway.sendAndWait(createOrderItemCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
