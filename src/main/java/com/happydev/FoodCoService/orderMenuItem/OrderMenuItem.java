package com.happydev.FoodCoService.orderMenuItem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuItem {

    @Id
    private String orderMenuItemId;
    @NotBlank
    private String menuItemId;
    private Integer quantity;
}
