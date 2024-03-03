package com.originalstuidos.productservice.service;

import com.originalstuidos.productservice.dto.ProductRequest;
import com.originalstuidos.productservice.dto.ProductResponse;
import com.originalstuidos.productservice.model.Product;
import com.originalstuidos.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved", product.getId());


    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
       return products.stream().map(n -> mapToProduct(n)).toList();
        }

    private ProductResponse mapToProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

}

