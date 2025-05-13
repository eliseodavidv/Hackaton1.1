package com.example.recuperacion.listeners;

import com.example.recuperacion.events.OrderCreateEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {
    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void onOrderCreated(OrderCreateEvent event) {
        logger.info("Registrando pedido en el log de auditoría");
        logger.info("ID Pedido: {}", event.getOrderId());
        logger.info("Cliente: {}", event.getEmail());
        logger.info("Productos:");
        event.getProducts().forEach(product ->
                logger.info(" - {} (Cantidad: {}, Stock restante: {})",
                        product.getName(),
                        product.getQuantity(),
                        product.getAvailableStock())
        );
        logger.info("Pedido registrado en auditoría exitosamente");
    }
}