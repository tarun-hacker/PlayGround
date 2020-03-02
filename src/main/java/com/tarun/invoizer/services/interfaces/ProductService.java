package com.tarun.invoizer.services.interfaces;

import com.tarun.invoizer.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    Product addProduct(Product product);
    Product removeProduct(Product product);
    Product updateProduct(Product product);
    Optional<Product> findProductById(Long id);
    Page<Product> getAllProducts(Pageable pageable);
    Page<Product> getAllProducts(Long id,Pageable pageable);
}
