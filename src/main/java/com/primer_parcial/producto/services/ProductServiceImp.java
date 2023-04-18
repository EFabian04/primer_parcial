package com.primer_parcial.producto.services;

import com.primer_parcial.producto.models.Product;
import com.primer_parcial.producto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productBD = productRepository.findById(id).get();
        productBD.setProduct(product.getProduct());
        productBD.setType(product.getType());
        productBD.setPrice(product.getPrice());
        productBD.setStock(product.getStock());
        return productRepository.save(productBD);
    }
}
