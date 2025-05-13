package com.example.recuperacion.events;

import com.example.recuperacion.model.Product;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class OrderCreateEvent extends ApplicationEvent {
    private final String orderId;
    private final String email;
    private final List<Product> products;

    public OrderCreateEvent(Object source, String orderId, String email, List<Product> products) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.products = products;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getProducts() {
        return products;
    }
}