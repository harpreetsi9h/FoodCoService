package com.happydev.FoodCoService.orderItem.command.api.aggregate;

import com.happydev.FoodCoService.orderItem.command.api.commands.CreateOrderItemCommand;
import com.happydev.FoodCoService.orderItem.command.api.events.OrderItemCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderItemAggregate {

    @AggregateIdentifier
    private String orderItemId;
    private String menuItemId;
    private Integer quantity;

    @CommandHandler
    public OrderItemAggregate(CreateOrderItemCommand createCommand) {

        OrderItemCreatedEvent createdEvent = new OrderItemCreatedEvent();

        BeanUtils.copyProperties(createCommand, createdEvent);

        AggregateLifecycle.apply(createdEvent);
    }

    public OrderItemAggregate() { }
    @EventSourcingHandler
    public void on(OrderItemCreatedEvent createdEvent) {
        this.orderItemId = createdEvent.getOrderItemId();
        this.menuItemId = createdEvent.getMenuItemId();
        this.quantity = createdEvent.getQuantity();
    }
}
