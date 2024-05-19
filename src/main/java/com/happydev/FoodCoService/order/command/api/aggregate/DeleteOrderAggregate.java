package com.happydev.FoodCoService.order.command.api.aggregate;

import com.happydev.FoodCoService.order.command.api.commands.CreateOrderCommand;
import com.happydev.FoodCoService.order.command.api.commands.DeleteOrderCommand;
import com.happydev.FoodCoService.order.command.api.events.OrderCreatedEvent;
import com.happydev.FoodCoService.order.command.api.events.OrderDeletedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

//We cannot have more than one Aggregate with same ID, so we are using disposable deleteOrderId for this aggregate.
@Aggregate
public class DeleteOrderAggregate {

    @AggregateIdentifier
    private String deleteOrderId;
    private String orderId;

    @CommandHandler
    public DeleteOrderAggregate(DeleteOrderCommand command) {

        OrderDeletedEvent event = new OrderDeletedEvent();

        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    public DeleteOrderAggregate() {
    }

    @EventSourcingHandler
    public void on(OrderDeletedEvent event) {
        this.orderId = event.getOrderId();
        this.deleteOrderId = event.getDeleteOrderId();
    }
}
