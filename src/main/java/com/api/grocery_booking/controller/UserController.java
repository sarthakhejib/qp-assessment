package com.api.grocery_booking.controller;

import com.api.grocery_booking.model.GroceryItem;
import com.api.grocery_booking.model.GroceryOrder;
import com.api.grocery_booking.model.User;
import com.api.grocery_booking.service.GroceryItemService;
import com.api.grocery_booking.service.GroceryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/groceries")
public class UserController {

    @Autowired
    private GroceryOrderService groceryOrderService;

    @Autowired
    private GroceryItemService groceryItemService;

    //List of all the grocery items available
    @GetMapping
    public List<GroceryItem> getAllAvailableItems() {
        return groceryOrderService.viewAvailableItems();
    }

    //Place order by providing user id and ids of the groceries available
    @PostMapping("/{id}/order")
    public ResponseEntity<GroceryOrder> placeOrder(@PathVariable Integer id,@RequestBody List<Integer> items) throws Exception {
        groceryOrderService.placeOrder(id,items);
        return new ResponseEntity( HttpStatus.OK);
    }





}