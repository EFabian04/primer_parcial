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
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean updateProduct(Long id, Product product) {
        try {
            Product productBD = productRepository.findById(id).get();
            if (productBD == null) {
                return false;
            }
            productBD.setTitle(product.getTitle());
            productBD.setPrice(product.getPrice());
            productBD.setDescription(product.getDescription());
            productBD.setImage(product.getImage());
            productBD.setCategory(product.getCategory());
            Product productUp = productRepository.save(productBD);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteProduct(Long id, Product product) {
        try {
            Product productBD = productRepository.findById(id).get();
            if (productBD == null){
                return false;
            }
            productRepository.delete(productBD);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
