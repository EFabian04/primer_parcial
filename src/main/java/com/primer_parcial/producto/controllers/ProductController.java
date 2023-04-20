package com.primer_parcial.producto.controllers;

import com.primer_parcial.producto.models.Product;
import com.primer_parcial.producto.service.ProductServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

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

    @GetMapping(value = "/products")
    public ResponseEntity<List> getAllProduct(){
        Map response = new HashMap();
        try{
            return new ResponseEntity(productServiceImp.getAllProduct(), HttpStatus.OK);
        }catch (Exception e){
            response.put("message","no hay productos registrados");
            return new ResponseEntity(response, HttpStatus.MULTI_STATUS);
        }
    }

    @PostMapping(value = "/product")
    public ResponseEntity createProduct(@RequestBody Product product){

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
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product){

        Map response = new HashMap<>();
        try{
            System.out.println(product);

            response.put("message","Se actualizó el producto");
            response.put("data",productServiceImp.updateProduct(id,product));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e) {
            response.put("message", "No se actualizó el producto");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id, Product product){
        Map response = new HashMap();
        Boolean productDB = productServiceImp.deleteProduct(id, product);
        try{
            if (productDB == null){
                response.put("massage", "No se encontró el producto");
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }else {
                response.put("massage", "Se eliminó el producto");
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            response.put("massage", "Error al eliminar");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

}
