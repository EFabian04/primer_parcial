package com.primer_parcial.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.primer_parcial.producto.models.Product;
public interface ProductRepository extends JpaRepository<Product,Long> {

}
