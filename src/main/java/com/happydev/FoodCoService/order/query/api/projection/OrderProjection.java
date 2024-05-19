package com.happydev.FoodCoService.order.query.api.projection;

import com.happydev.FoodCoService.order.core.data.Order;
import com.happydev.FoodCoService.order.core.data.OrderRepository;
import com.happydev.FoodCoService.order.core.model.OrderModel;
import com.happydev.FoodCoService.order.query.api.queries.GetOrderByIdQuery;
import com.happydev.FoodCoService.order.query.api.queries.GetOrderQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderProjection {

    private final OrderRepository repository;

    public OrderProjection(OrderRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public List<OrderModel> handle(GetOrderQuery query) {

        List<Order> ordersList = repository.findAll();

        return ordersList.stream().map(
                order -> OrderModel.builder()
                        .orderId(order.getOrderId())
                        .customerId(order.getCustomerId())
                        .subTotal(order.getSubTotal())
                        .serviceFee(order.getServiceFee())
                        .deliveryFee(order.getDeliveryFee())
                        .totalAmount(order.getTotalAmount())
                        .orderStatus(order.getOrderStatus())
                        .createdAt(order.getCreatedAt())
                        .build()
        ).collect(Collectors.toList());
    }

    @QueryHandler
    public OrderModel handle(GetOrderByIdQuery query) {
        if(repository.findById(query.getOrderId()).isEmpty())
            return null;
        Order order = repository.findById(query.getOrderId()).get();
        return OrderModel.builder()
                .orderId(order.getOrderId())
                .customerId(order.getCustomerId())
                .subTotal(order.getSubTotal())
                .serviceFee(order.getServiceFee())
                .deliveryFee(order.getDeliveryFee())
                .totalAmount(order.getTotalAmount())
                .orderStatus(order.getOrderStatus())
                .createdAt(order.getCreatedAt())
                .build();
    }

}
