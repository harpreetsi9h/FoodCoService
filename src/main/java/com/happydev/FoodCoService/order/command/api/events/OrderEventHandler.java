package com.happydev.FoodCoService.order.command.api.events;

import com.happydev.FoodCoService.order.core.data.Order;
import com.happydev.FoodCoService.order.core.data.OrderRepository;
import com.happydev.FoodCoService.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
//TODO: find a way to send Error msgs in Api Response like MVC pattern.
@Slf4j
@Component
public class OrderEventHandler {

    private final OrderRepository repository;

    public OrderEventHandler(OrderRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();

        BeanUtils.copyProperties(event, order);

        repository.save(order);
        log.info("OrderCreatedEvent - Order Created with Id=" + event.getOrderId());
    }

    @EventHandler
    public void on(OrderUpdatedEvent event) {

        if(!repository.existsById(event.getOrderId())) {
            log.error("OrderUpdatedEvent - " + Constants.ORDER_NOT_FOUND_WITH_ID + event.getOrderId());
            return;
        }

        Order order = new Order();

        BeanUtils.copyProperties(event, order);

        repository.save(order);
        log.info("OrderUpdatedEvent - Order Updated with Id=" + event.getOrderId());
    }

    @EventHandler
    public void on(OrderDeletedEvent event) {
        if(!repository.existsById(event.getOrderId())) {
            log.error("OrderDeletedEvent - " + Constants.ORDER_NOT_FOUND_WITH_ID + event.getOrderId());
            return;
        }

        repository.deleteById(event.getOrderId());
        log.info("OrderDeletedEvent - Order Deleted with Id=" + event.getOrderId());
    }



}
