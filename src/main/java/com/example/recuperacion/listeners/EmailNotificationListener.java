package com.example.recuperacion.listeners;

import com.example.recuperacion.events.OrderCreateEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    public void onOrderCreated(OrderCreateEvent event) {
        logger.debug("Enviando correo de confirmación para el pedido: {}", event.getOrderId());
        logger.debug("Correo enviado a: {}", event.getEmail());
        logger.debug("Detalles del pedido:");
        event.getProducts().forEach(product ->
                logger.debug("Producto: {}, Cantidad: {}", product.getName(), product.getQuantity())
        );
        logger.info("Correo de confirmación enviado exitosamente para el pedido {}", event.getOrderId());
    }
}