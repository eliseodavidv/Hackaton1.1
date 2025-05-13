package com.example.recuperacion.listeners;

import com.example.recuperacion.events.OrderCreateEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {
    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void onOrderCreated(OrderCreateEvent event) {
        logger.debug("Actualizando inventario para el pedido: {}", event.getOrderId());

        // Cantidad fija que deseas restar del stock disponible
        int quantityToReduce = 4;

        // Actualizamos el inventario para cada producto
        event.getProducts().forEach(product -> {
            // Aseguramos que se reste la cantidad deseada (en este caso, 4 unidades)
            int newStock = product.getAvailableStock() - quantityToReduce;
            logger.debug("Reduciendo stock de {} de {} a {}",
                    product.getName(),
                    product.getAvailableStock(),
                    newStock);

            // Actualizamos el stock del producto (en una aplicación real, esto debería actualizar la base de datos)
            product.setAvailableStock(newStock);
        });

        logger.info("Inventario actualizado exitosamente para el pedido {}", event.getOrderId());
    }
}
