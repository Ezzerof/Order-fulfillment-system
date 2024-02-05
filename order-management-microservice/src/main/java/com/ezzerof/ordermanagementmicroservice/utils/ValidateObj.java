package com.ezzerof.ordermanagementmicroservice.utils;

import com.ezzerof.ordermanagementmicroservice.exception.InvalidItemException;
import com.ezzerof.ordermanagementmicroservice.exception.InvalidOrderException;
import com.ezzerof.ordermanagementmicroservice.model.Item;
import com.ezzerof.ordermanagementmicroservice.model.Order;

public class ValidateObj {

    public static void validateItem(Item item) {
        if (item == null ||
                item.getItemName().isEmpty() ||
                (item.getQuantity() < 0 || item.getQuantity() > 100) ||
                item.getPrice() < 0)
            throw new InvalidItemException("Invalid Item data");
    }

    public static void validateOrder(Order order) {
        if (order == null ||
                order.getOrderStatus() == null ||
                order.getCustomerName() == null ||
                order.getDeliveryAddress() == null ||
                order.getList().isEmpty() ||
                order.getOrderedDateTime() == null ||
                order.getDeliveryDateTime() == null) {
            throw new InvalidOrderException("Invalid order data");
        }
    }
}
