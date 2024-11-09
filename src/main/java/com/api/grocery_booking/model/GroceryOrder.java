package com.api.grocery_booking.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "groceryorder")
@Data
@NoArgsConstructor
public class GroceryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<GroceryItem> items;

    public GroceryOrder(User user, List<GroceryItem> items) {
        this.user = user;
        this.items = items;
    }
}