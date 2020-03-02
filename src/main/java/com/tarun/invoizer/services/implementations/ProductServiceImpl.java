package com.tarun.invoizer.services.implementations;

import com.tarun.invoizer.models.Product;
import com.tarun.invoizer.repositories.ProductRepository;
import com.tarun.invoizer.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;




    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product removeProduct(Product product) {
        productRepository.delete(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllProducts(Long id, Pageable pageable) {
        return productRepository.findByUserId(id,pageable);
    }
}
