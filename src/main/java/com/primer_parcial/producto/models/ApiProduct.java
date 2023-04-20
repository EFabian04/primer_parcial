package com.primer_parcial.producto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiProduct {
    private long id;
    private String title;
    private float price;
    private String description;
    private String image;
    private String category;
}