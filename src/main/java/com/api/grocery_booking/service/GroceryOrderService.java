package com.api.grocery_booking.service;

import com.api.grocery_booking.model.GroceryItem;
import com.api.grocery_booking.model.GroceryOrder;
import com.api.grocery_booking.model.User;
import com.api.grocery_booking.repository.GroceryItemRepository;
import com.api.grocery_booking.repository.GroceryOrderRepository;
import com.api.grocery_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryOrderService {

    @Autowired
    private GroceryOrderRepository groceryOrderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> viewAvailableItems() {
        return groceryItemRepository.findAll();
    }

    /**
     * Get user id and list of grocery ids as parameter, place an order and update inventory levels
     * @param userId
     * @param itemIds
     * @return GroceryOrder
     * @throws Exception
     */

    public GroceryOrder placeOrder(int userId, List<Integer> itemIds) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);

        for (GroceryItem item : items) {
            if (item.getQuantity() <= 0) {
                throw new Exception("Item " + item.getName() + " is out of stock.");
            }

            item.setQuantity(item.getQuantity() - 1);
        }

        groceryItemRepository.saveAll(items);

        GroceryOrder order = new GroceryOrder(user, items);
        return (GroceryOrder) groceryOrderRepository.save(order);
    }

    public Iterable<GroceryOrder> getAllOrders(){
        return groceryOrderRepository.findAll();
    }

}
