package com.happydev.FoodCoService.orderItem;

import com.happydev.FoodCoService.exception.CustomMessageException;
import com.happydev.FoodCoService.orderItem.core.data.OrderItemRepository;
import com.happydev.FoodCoService.orderItem.core.model.OrderItemModel;
import com.happydev.FoodCoService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {
    private final OrderItemRepository repository;

    @Autowired
    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

//    public List<OrderItemModel> getOrderItems() {
//        return repository.findAll();
//    }
//
//    public String saveOrderItem(OrderItemModel orderItem) {
//        orderItem.setOrderItemId(UUID.randomUUID().toString());
//        repository.save(orderItem);
//        return orderItem.getOrderItemId();
//    }
//
//    public String removeOrderItem(String orderItemId) throws CustomMessageException {
//        if (repository.findById(orderItemId).isPresent()) {
//            repository.deleteById(orderItemId);
//            return Constants.ORDER_ITEM_REMOVED_SUCCESSFULLY;
//        }
//        else throw new CustomMessageException(Constants.ORDER_ITEM_NOT_FOUND_WITH_ID+orderItemId);
//
//    }
//
//    public OrderItemModel getOrderItem(String orderItemId) throws CustomMessageException {
//        if(repository.findById(orderItemId).isEmpty())
//            throw new CustomMessageException(Constants.ORDER_ITEM_NOT_FOUND_WITH_ID+orderItemId);
//        return repository.findById(orderItemId).get();
//    }
//
//    public String updateOrderItem(OrderItemModel orderItem) throws CustomMessageException {
//
//        if (repository.findById(orderItem.getOrderItemId()).isPresent()) {
//            repository.save(orderItem);
//            return Constants.ORDER_ITEM_UPDATED_SUCCESSFULLY;
//        }
//        else throw new CustomMessageException(Constants.ORDER_ITEM_NOT_FOUND_WITH_ID+ orderItem.getOrderItemId());
//
//    }
}
