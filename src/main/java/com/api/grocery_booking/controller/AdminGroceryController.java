package com.api.grocery_booking.controller;

import com.api.grocery_booking.model.GroceryItem;
import com.api.grocery_booking.model.GroceryOrder;
import com.api.grocery_booking.model.User;
import com.api.grocery_booking.service.AdminService;
import com.api.grocery_booking.service.GroceryItemService;
import com.api.grocery_booking.service.GroceryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;



import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/groceries")
public class AdminGroceryController {

    @Autowired
    private GroceryItemService groceryItemService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private GroceryOrderService groceryOrderService;

    //Adding grocery
    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        return new ResponseEntity<>(groceryItemService.addGroceryItem(item), HttpStatus.CREATED);
    }

    //Get all groceryItems
    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    //Update a grocery item based on id
    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Integer id, @RequestBody GroceryItem item) {
        return new ResponseEntity<>(groceryItemService.updateGroceryItem(id, item), HttpStatus.OK);
    }

    //Delete a grocery item based on id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Integer id) {
        groceryItemService.deleteGroceryItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Check inventory status
    @PatchMapping("/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Integer id, @RequestBody Map<String, Integer> inventory) {
        return new ResponseEntity<>(groceryItemService.updateInventory(id, inventory.get("quantity")), HttpStatus.OK);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Endpoints for adding users and getting the list of users present
    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user){
        return new ResponseEntity(adminService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    //Get all the orders
    @GetMapping("/orders")
    public Iterable<GroceryOrder> getAllOrders(){
        return groceryOrderService.getAllOrders();
    }
}