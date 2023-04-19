package com.primer_parcial.producto.services;

import com.primer_parcial.producto.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> allProduct();
    Product createProduct(Product product);
    Boolean updateProduct(Long id,Product product);
    Boolean deleteProduct(Long id, Product product);
}
