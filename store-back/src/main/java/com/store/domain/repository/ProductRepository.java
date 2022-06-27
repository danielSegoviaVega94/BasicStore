package com.store.domain.repository;

import com.store.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getAllByCategory(Integer idCategory);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getById(Long id);
    Product save(Product product);
    void delete(Long id);
    Optional<Product> findByNameProduct(String nameProduct);
}
