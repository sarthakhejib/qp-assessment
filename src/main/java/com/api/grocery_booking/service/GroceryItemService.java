package com.api.grocery_booking.service;

import com.api.grocery_booking.model.GroceryItem;
import com.api.grocery_booking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    /**
     * Add grocery item
     * @param item
     * @return GroceryItem
     */
    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    /**
     * Fetch all the grocery items
     * @return GroceryItems
     */
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    /**
     * Delete grocery item
     * @param id
     */
    public void deleteGroceryItem(Integer id) {
        groceryItemRepository.deleteById(id);
    }

    /**
     * Update grocery item
     * @param id
     * @return GroceryItem
     */
    public GroceryItem updateGroceryItem(Integer id, GroceryItem newItemDetails) {
        GroceryItem groceryItem = groceryItemRepository.findById(id).get();
        groceryItem.setName(newItemDetails.getName());
        groceryItem.setPrice(newItemDetails.getPrice());
        groceryItem.setQuantity(newItemDetails.getQuantity());
        groceryItem.setUnitOfMeasurement(newItemDetails.getUnitOfMeasurement());
        return groceryItemRepository.save(groceryItem);
    }

    /**
     * Update inventory
     * @param id, newQuantity
     * @return GroceryItem
     */
    public GroceryItem updateInventory(Integer id, Integer newQuantity) {
        GroceryItem groceryItem = groceryItemRepository.findById(id).get();
        groceryItem.setQuantity(newQuantity);
        return groceryItemRepository.save(groceryItem);
    }
}
