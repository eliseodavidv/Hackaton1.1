package com.example.recuperacion.model;

import java.util.List;
import lombok.Data;

@Data
public class OrderRequest {
    private String email;
    private List<Product> products;
}