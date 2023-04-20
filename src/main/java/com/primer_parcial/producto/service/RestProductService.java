package com.primer_parcial.producto.service;

import com.primer_parcial.producto.models.ApiProduct;
import com.primer_parcial.producto.repository.ProductRepository;
import com.primer_parcial.producto.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primer_parcial.producto.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class RestProductService {
    private final RestTemplate restTemplate;
    private final ProductRepository productRepository;

    public Object getById(Long id) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ApiProduct> entity = new HttpEntity<ApiProduct>(headers);
        String response = restTemplate.exchange("https://fakestoreapi.com/products" + id.toString(), HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        ApiProduct ApiProduct = objectMapper.readValue(response.substring(7), ApiProduct.class);

        return ApiProduct;
    }

    public Object getAllProduct() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ApiProduct> entity = new HttpEntity<ApiProduct>(headers);

        return restTemplate.exchange("https://fakestoreapi.com/products" , HttpMethod.GET, entity, Object.class).getBody();

    }

    public Object saveProduct(Long id) throws JsonProcessingException{

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ApiProduct> entity = new HttpEntity<ApiProduct>(headers);
        String response = restTemplate.exchange("https://fakestoreapi.com/products" + id.toString(), HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Product apiProduct = objectMapper.readValue(response.substring(7), Product.class);

        try {
            Product productSave = productRepository.save(apiProduct);
            return apiProduct;
        }catch (Exception e){
            return false;
        }

    }
}
