package com.primer_parcial.producto.controllers;

import com.primer_parcial.producto.models.Product;
import com.primer_parcial.producto.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;
    @GetMapping(value = "/product/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id){

        Map response = new HashMap<>();

        try{
            response.put("message","Se encontró el producto");
            response.put("data",productServiceImp.getProductById(id));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
            response.put("message", "No se encontró el producto");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/product")
    public ResponseEntity createUser(@RequestBody Product product){

        Map response = new HashMap<>();
        try{
            response.put("message","Se guardó el producto");
            response.put("data",productServiceImp.createProduct(product));
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch(Exception e) {
            response.put("message", "No se guardó el producto");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity updateUser(@PathVariable(name = "id") Long id, Product product){

        Map response = new HashMap<>();
        try{
            response.put("message","Se actualizó el producto");
            response.put("data",productServiceImp.updateProduct(id,product));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
            response.put("message", "No se actualizó el producto");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

}
