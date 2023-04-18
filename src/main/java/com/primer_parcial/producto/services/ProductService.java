package com.primer_parcial.producto.services;

import com.primer_parcial.producto.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> allProduct();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
}
