package com.example.recuperacion.controllers;

import com.example.recuperacion.events.OrderCreateEvent;
import com.example.recuperacion.model.OrderRequest;
import com.example.recuperacion.model.Product;
import com.example.recuperacion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;  // Inyectamos el servicio

    @PostMapping("/orders")
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        // Delegamos la creación del pedido al servicio
        return orderService.createOrder(orderRequest);
    }
}