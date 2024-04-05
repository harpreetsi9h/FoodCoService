package com.happydev.FoodCoService.orderItem.query.api.controller;

import com.happydev.FoodCoService.orderItem.core.model.OrderItemModel;
import com.happydev.FoodCoService.orderItem.query.api.queries.GetOrderItemQuery;
import com.happydev.FoodCoService.util.Constants;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.URL_API)
public class OrderItemQueryController {

    private final QueryGateway queryGateway;

    public OrderItemQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(Constants.URL_ORDER_ITEM)
    public ResponseEntity<List<OrderItemModel>> getOrderItems() {

        GetOrderItemQuery getOrderItemQuery = new GetOrderItemQuery();

        List<OrderItemModel> orderItems =
                queryGateway.query(getOrderItemQuery, ResponseTypes.multipleInstancesOf(OrderItemModel.class)).join();
        return ResponseEntity.ok(orderItems);
    }
}
