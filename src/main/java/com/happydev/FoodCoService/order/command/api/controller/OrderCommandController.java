package com.happydev.FoodCoService.order.command.api.controller;

import com.happydev.FoodCoService.order.command.api.commands.CreateOrderCommand;
import com.happydev.FoodCoService.order.command.api.commands.DeleteOrderCommand;
import com.happydev.FoodCoService.order.command.api.commands.UpdateOrderCommand;
import com.happydev.FoodCoService.order.core.model.OrderModel;
import com.happydev.FoodCoService.util.Constants;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;

//TODO: Update deliveryFee from backend instead of getting it from frontend

@Slf4j
@RestController
@RequestMapping(Constants.URL_API)
public class OrderCommandController {

    private final CommandGateway commandGateway;

    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(Constants.URL_ORDER)
    public ResponseEntity<String> createOrder(@RequestBody @Valid OrderModel order) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
                .orderId(UUID.randomUUID().toString())
                .customerId(order.getCustomerId())
                .subTotal(order.getSubTotal())
                .serviceFee(order.getServiceFee())
                .deliveryFee(order.getDeliveryFee())
                .totalAmount(order.getTotalAmount())
                .orderStatus(order.getOrderStatus())
                .createdAt(timestamp.toString())
                .build();

        String result = commandGateway.sendAndWait(createOrderCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //TODO: Restrict some params to get updated like createAt, customerId etc.
    @PutMapping(Constants.URL_ORDER)
    public ResponseEntity<String> updateOrder(@RequestBody OrderModel order) {

        UpdateOrderCommand updateOrderCommand = UpdateOrderCommand.builder()
                .updateOrderId(UUID.randomUUID().toString())
                .orderId(order.getOrderId())
                .customerId(order.getCustomerId())
                .subTotal(order.getSubTotal())
                .serviceFee(order.getServiceFee())
                .deliveryFee(order.getDeliveryFee())
                .totalAmount(order.getTotalAmount())
                .orderStatus(order.getOrderStatus())
                .createdAt(order.getCreatedAt())
                .build();

        String result = commandGateway.sendAndWait(updateOrderCommand);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(Constants.URL_ORDER+"/{orderId}")
    public ResponseEntity<String> removeOrder(@PathVariable String orderId) {
        DeleteOrderCommand deleteOrderCommand = DeleteOrderCommand.builder()
                .deleteOrderId(UUID.randomUUID().toString())
                .orderId(orderId)
                .build();

        String result = commandGateway.sendAndWait(deleteOrderCommand);
        log.info("RemoveOrderApi - result = " + result);
        return ResponseEntity.ok().body(result);
    }

}
