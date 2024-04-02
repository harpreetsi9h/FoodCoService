package com.happydev.FoodCoService.orderMenuItem;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderMenuItemService {
    private final OrderMenuItemRepository repository;

    @Autowired
    public OrderMenuItemService(OrderMenuItemRepository repository) {
        this.repository = repository;
    }

    public List<OrderMenuItem> getOrderMenuItems() {
        return repository.findAll();
    }

    public String saveOrderMenuItem(OrderMenuItem orderMenuItem) {
        orderMenuItem.setOrderMenuItemId(UUID.randomUUID().toString());
        repository.save(orderMenuItem);
        return orderMenuItem.getOrderMenuItemId();
    }

    public String removeOrderMenuItem(String orderMenuItemId) throws CustomMessageException {
        if (repository.findById(orderMenuItemId).isPresent()) {
            repository.deleteById(orderMenuItemId);
            return Constants.ORDER_MENU_ITEM_REMOVED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.ORDER_MENU_ITEM_NOT_FOUND_WITH_ID+orderMenuItemId);

    }

    public OrderMenuItem getOrderMenuItem(String orderMenuItemId) throws CustomMessageException {
        if(repository.findById(orderMenuItemId).isEmpty())
            throw new CustomMessageException(Constants.ORDER_MENU_ITEM_NOT_FOUND_WITH_ID+orderMenuItemId);
        return repository.findById(orderMenuItemId).get();
    }

    public String updateOrderMenuItem(OrderMenuItem orderMenuItem) throws CustomMessageException {

        if (repository.findById(orderMenuItem.getOrderMenuItemId()).isPresent()) {
            repository.save(orderMenuItem);
            return Constants.ORDER_MENU_ITEM_UPDATED_SUCCESSFULLY;
        }
        else throw new CustomMessageException(Constants.ORDER_MENU_ITEM_NOT_FOUND_WITH_ID+orderMenuItem.getOrderMenuItemId());

    }
}
