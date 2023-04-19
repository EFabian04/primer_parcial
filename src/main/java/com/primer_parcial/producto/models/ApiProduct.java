package com.primer_parcial.producto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiProduct {
    long id;
    String title;
    float price;
    String description;
    String image;
    String category;
}