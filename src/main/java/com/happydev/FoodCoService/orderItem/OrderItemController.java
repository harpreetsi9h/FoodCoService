package com.happydev.FoodCoService.orderItem;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.orderItem.core.model.OrderItemModel;
import com.happydev.FoodCoService.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.URL_API)
public class OrderItemController {

    private final OrderItemService service;

    @Autowired
    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

//    @GetMapping(Constants.URL_ORDER_ITEM)
//    public ResponseEntity<List<OrderItemModel>> getOrderItems() {
//        return ResponseEntity.ok(service.getOrderItems());
//    }

//    @PostMapping(Constants.URL_ORDER_ITEM)
//    public ResponseEntity<String> addOrderItem(@RequestBody @Valid OrderItemModel orderItem) {
//        String orderMenuItemId = service.saveOrderItem(orderItem);
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderMenuItemId);
//    }

//    @GetMapping(Constants.URL_ORDER_ITEM+"/{orderMenuItemId}")
//    public ResponseEntity<OrderItemModel> getOrderItem(@PathVariable String orderMenuItemId) throws CustomMessageException {
//        return ResponseEntity.ok(service.getOrderItem(orderMenuItemId));
//    }
//
//    @DeleteMapping(Constants.URL_ORDER_ITEM+"/{orderMenuItemId}")
//    public ResponseEntity<String> removeOrderItem(@PathVariable String orderMenuItemId) throws CustomMessageException {
//        return ResponseEntity.ok(service.removeOrderItem(orderMenuItemId));
//    }
//
//    @PutMapping(Constants.URL_ORDER_ITEM)
//    public ResponseEntity<String> updateOrderItem(@RequestBody @Valid OrderItemModel orderItem) throws CustomMessageException {
//        return ResponseEntity.ok(service.updateOrderItem(orderItem));
//    }
}
