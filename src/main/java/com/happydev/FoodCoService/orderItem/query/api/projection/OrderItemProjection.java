package com.happydev.FoodCoService.orderItem.query.api.projection;

import com.happydev.FoodCoService.orderItem.core.data.OrderItem;
import com.happydev.FoodCoService.orderItem.core.data.OrderItemRepository;
import com.happydev.FoodCoService.orderItem.core.model.OrderItemModel;
import com.happydev.FoodCoService.orderItem.query.api.queries.GetOrderItemQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemProjection {

    private final OrderItemRepository repository;

    public OrderItemProjection(OrderItemRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public List<OrderItemModel> handle(GetOrderItemQuery query) {
        List<OrderItem> orderItemList = repository.findAll();

        return orderItemList.stream().map(
                orderItem -> OrderItemModel.builder()
                        .orderItemId(orderItem.getOrderItemId())
                        .menuItemId(orderItem.getMenuItemId())
                        .quantity(orderItem.getQuantity())
                        .build()
        ).collect(Collectors.toList());
    }
}
