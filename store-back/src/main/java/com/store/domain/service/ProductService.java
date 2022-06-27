package com.store.domain.service;

import com.store.domain.dto.Product;
import com.store.domain.repository.ProductRepository;
import com.store.persistence.servicePersistence.ProductoServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductoServicePersistence productoServicePersistence;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getAllByCategory(Integer idCategory){
        return productRepository.getAllByCategory(idCategory);
    }

    public Optional<List<Product>> getScarseProducts(Integer quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Optional<Product> getById(Long id){
        return productRepository.getById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(Long id){
       try {
              productRepository.delete(id);
              return true;
         } catch (Exception e) {
              return false;
         }
            }

    public Optional<Product> findByNameProduct(String nameProduct){
        return productRepository.findByNameProduct(nameProduct);
    }

    public Product updateProduct(Product product, Long idProduct){
        return productoServicePersistence.updateProduct(product, idProduct);
    }
}
