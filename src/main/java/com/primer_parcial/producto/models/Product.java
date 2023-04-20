package com.primer_parcial.producto.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private float price;
    private String description;
    private String image;
    private String category;
}
