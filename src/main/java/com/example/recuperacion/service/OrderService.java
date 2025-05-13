package com.example.recuperacion.service;


import com.example.recuperacion.events.OrderCreateEvent;
import com.example.recuperacion.model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public String createOrder(OrderRequest orderRequest) {
        String orderId = UUID.randomUUID().toString();

        eventPublisher.publishEvent(new OrderCreateEvent(this, orderId, orderRequest.getEmail(), orderRequest.getProducts()));

        return "Pedido " + orderId + " creado exitosamente.";
    }
}
