package com.happydev.FoodCoService.order.query.api.controller;

import com.happydev.FoodCoService.order.core.model.OrderModel;
import com.happydev.FoodCoService.order.query.api.queries.GetOrderByIdQuery;
import com.happydev.FoodCoService.order.query.api.queries.GetOrderQuery;
import com.happydev.FoodCoService.util.Constants;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(Constants.URL_API)
public class OrderQueryController {

    private final QueryGateway queryGateway;

    public OrderQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(Constants.URL_ORDER)
    public ResponseEntity<List<OrderModel>> getOrders() {
        GetOrderQuery getOrderQuery = new GetOrderQuery();

        List<OrderModel> order =
                queryGateway.query(getOrderQuery, ResponseTypes.multipleInstancesOf(OrderModel.class)).join();
        return ResponseEntity.ok(order);
    }

    @GetMapping(Constants.URL_ORDER+"/{orderId}")
    public ResponseEntity<OrderModel> getOrder(@PathVariable String orderId) {
        GetOrderByIdQuery query = new GetOrderByIdQuery();
        query.setOrderId(orderId);

        OrderModel order =
                queryGateway.query(query, ResponseTypes.instanceOf(OrderModel.class)).join();
        return ResponseEntity.ok(order);
    }
}
