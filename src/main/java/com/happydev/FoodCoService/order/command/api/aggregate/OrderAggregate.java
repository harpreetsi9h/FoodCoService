package com.happydev.FoodCoService.order.command.api.aggregate;

import com.happydev.FoodCoService.order.command.api.commands.CreateOrderCommand;
import com.happydev.FoodCoService.order.command.api.commands.UpdateOrderCommand;
import com.happydev.FoodCoService.order.command.api.events.OrderCreatedEvent;
import com.happydev.FoodCoService.order.command.api.events.OrderUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {

        OrderCreatedEvent event = new OrderCreatedEvent();

        BeanUtils.copyProperties(createOrderCommand, event);

        AggregateLifecycle.apply(event);
    }

    public OrderAggregate() {
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.customerId = event.getCustomerId();
        this.subTotal = event.getSubTotal();
        this.serviceFee = event.getServiceFee();
        this.deliveryFee = event.getDeliveryFee();
        this.totalAmount = event.getTotalAmount();
        this.orderStatus = event.getOrderStatus();
        this.createdAt = event.getCreatedAt();
    }

}
