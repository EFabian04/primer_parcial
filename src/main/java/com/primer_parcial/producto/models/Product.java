package com.primer_parcial.producto.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String product;
    private String type;
    private float price;
    private int stock;
}
