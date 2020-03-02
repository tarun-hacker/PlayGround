package com.tarun.invoizer.controllers;

import com.tarun.invoizer.exceptions.InvalidResourceAccessException;
import com.tarun.invoizer.exceptions.ResourceNotFoundException;
import com.tarun.invoizer.models.Product;
import com.tarun.invoizer.models.User;
import com.tarun.invoizer.security.CustomUserDetail;
import com.tarun.invoizer.services.interfaces.ProductService;
import com.tarun.invoizer.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public Page<Product> getAllProducts(Pageable pageable, Authentication authentication) {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        return productService.getAllProducts(userDetail.getId(), pageable);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Authentication authentication) throws ResourceNotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        User user = userService.getById(userDetail.getId());
        product.setUser(user);
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product, Authentication authentication) throws ResourceNotFoundException {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        User user = userService.getById(userDetail.getId());
        product.setUser(user);
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity getProduct(@PathVariable("id") Long id, Authentication authentication) throws InvalidResourceAccessException {
        Product product = productService.findProductById(id).orElseGet(Product::new);
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        if (!product.getUser().getId().equals(userDetail.getId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid resource access attempt blocked");
        } else {
            return ResponseEntity.ok(product);
        }
    }


}
