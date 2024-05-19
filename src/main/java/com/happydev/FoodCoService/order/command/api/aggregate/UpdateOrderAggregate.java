package com.happydev.FoodCoService.order.command.api.aggregate;

import com.happydev.FoodCoService.order.command.api.commands.UpdateOrderCommand;
import com.happydev.FoodCoService.order.command.api.events.OrderUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

//TODO: if there is, find a way to use Create Order code to handle Update Order commands to reduce extra Update Order classes.
//We cannot have more than one Aggregate with same ID, so we are using disposable updateOrderId for this aggregate.
@Aggregate
public class UpdateOrderAggregate {

    @AggregateIdentifier
    private String updateOrderId;
    private String orderId;
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;

    @CommandHandler
    public UpdateOrderAggregate(UpdateOrderCommand updateOrderCommand) {

        OrderUpdatedEvent updatedEvent = new OrderUpdatedEvent();

        BeanUtils.copyProperties(updateOrderCommand, updatedEvent);

        AggregateLifecycle.apply(updatedEvent);
    }

    public UpdateOrderAggregate() {
    }

    @EventSourcingHandler
    public void on(OrderUpdatedEvent event) {
        this.updateOrderId = event.getUpdateOrderId();
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
