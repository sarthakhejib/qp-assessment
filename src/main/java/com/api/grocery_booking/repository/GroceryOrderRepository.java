package com.api.grocery_booking.repository;

import com.api.grocery_booking.model.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryOrderRepository extends JpaRepository<GroceryOrder, Integer> {
}