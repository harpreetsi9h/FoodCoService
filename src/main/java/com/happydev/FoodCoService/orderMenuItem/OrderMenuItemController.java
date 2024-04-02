package com.happydev.FoodCoService.orderMenuItem;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(Constants.URL_API)
public class OrderMenuItemController {

    private final OrderMenuItemService service;

    @Autowired
    public OrderMenuItemController(OrderMenuItemService service) {
        this.service = service;
    }

    @GetMapping(Constants.URL_ORDER_MENU_ITEM)
    public ResponseEntity<List<OrderMenuItem>> getOrderMenuItems() {
        return ResponseEntity.ok(service.getOrderMenuItems());
    }

    @PostMapping(Constants.URL_ORDER_MENU_ITEM)
    public ResponseEntity<String> addOrderMenuItem(@RequestBody @Valid OrderMenuItem orderMenuItem) {
        String orderMenuItemId = service.saveOrderMenuItem(orderMenuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMenuItemId);
    }

    @GetMapping(Constants.URL_ORDER_MENU_ITEM+"/{orderMenuItemId}")
    public ResponseEntity<OrderMenuItem> getOrderMenuItem(@PathVariable String orderMenuItemId) throws CustomMessageException {
        return ResponseEntity.ok(service.getOrderMenuItem(orderMenuItemId));
    }

    @DeleteMapping(Constants.URL_ORDER_MENU_ITEM+"/{orderMenuItemId}")
    public ResponseEntity<String> removeOrderMenuItem(@PathVariable String orderMenuItemId) throws CustomMessageException {
        return ResponseEntity.ok(service.removeOrderMenuItem(orderMenuItemId));
    }

    @PutMapping(Constants.URL_ORDER_MENU_ITEM)
    public ResponseEntity<String> updateOrderMenuItem(@RequestBody @Valid OrderMenuItem orderMenuItem) throws CustomMessageException {
        return ResponseEntity.ok(service.updateOrderMenuItem(orderMenuItem));
    }
}
