package com.store.controller;

import com.store.domain.dto.Product;
import com.store.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        // if empty return no content
        if (productService.getAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable Long idProduct) {
        // if empty return no content
        if (productService.getById(idProduct).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.getById(idProduct));
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<Optional<List<Product>>> getAllByCategory(@PathVariable Integer idCategory ) {
        // if empty return no content
        if (productService.getAllByCategory(idCategory).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.getAllByCategory(idCategory));
    }

    @GetMapping("/scarse/{quantity}")
    public ResponseEntity<Optional<List<Product>>> getScarseProducts(@PathVariable Integer quantity) {
        // if empty return no content
        if (productService.getScarseProducts(quantity).isEmpty()) {
            String message = "No hay productos con stock menor a " + quantity;
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.getScarseProducts(quantity));
    }

    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        //if product name is exist return conflict
        if (productService.findByNameProduct(product.getProductName()).isPresent()) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idProduct) {
        //if product name is exist return conflict
        if (productService.getById(idProduct).isEmpty()) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok(productService.delete(idProduct));
    }

    @PutMapping("/update/{idProduct}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long idProduct) {
        //if product name is exist return conflict
        if (productService.getById(idProduct).isEmpty()) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok(productService.updateProduct(product, idProduct));
    }



}
