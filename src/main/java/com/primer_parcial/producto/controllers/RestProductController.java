package com.primer_parcial.producto.controllers;

import com.primer_parcial.producto.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.primer_parcial.producto.models.ApiProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class RestProductController {
    private final RestProductController restProductService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restProductService.getProduct(id), HttpStatus.OK);
    }
    /*
    @GetMapping(value = "/all")
    public ResponseEntity<List<ApiProduct>> getAllProduct() throws JsonProcessingException {
        return new ResponseEntity(restProductService.getAllProduct(), HttpStatus.OK);
    }*/

    @PostMapping(value = "/{id}")
    public ResponseEntity saveProduct(@PathVariable Long id) throws JsonProcessingException {
        return new ResponseEntity(restProductService.saveProduct(id), HttpStatus.ACCEPTED);
    }
}
