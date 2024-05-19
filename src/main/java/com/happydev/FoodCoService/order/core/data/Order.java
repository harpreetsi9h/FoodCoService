package com.happydev.FoodCoService.order.core.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;
    private String customerId;
    private Float subTotal;
    private Float serviceFee;
    private Float deliveryFee;
    private Float totalAmount;
    private String orderStatus;
    private String createdAt;
}
