package com.store.persistence.servicePersistence;

import com.store.domain.dto.Product;
import com.store.domain.repository.ProductRepository;
import com.store.persistence.entity.Producto;
import com.store.persistence.mapper.ProductMapper;
import com.store.persistence.repositoryPersistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoServicePersistence implements ProductRepository {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired(required = true)
    public ProductMapper productMapper;

    public List<Product> getAll(){
        List<Producto> productos = productoRepository.findAll();
        return productMapper.toProductList(productos);
    }

    @Override
    public Optional<List<Product>> getAllByCategory(Integer idCategory) {
        List<Producto> productos = productoRepository.findByIdCategoria(idCategory);
        return Optional.of(productMapper.toProductList(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        List<Producto> productos = productoRepository.findByStockProductoLessThan(quantity);
        return Optional.of(productMapper.toProductList(productos));
    }

    @Override
    public Optional<Product> getById(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return Optional.ofNullable(productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productoRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findByNameProduct(String nameProduct) {
        Producto producto = productoRepository.findByNombreProducto(nameProduct);
        return Optional.ofNullable(productMapper.toProduct(producto));
    }

    public Product updateProduct(Product product, Long idProduct){
        Producto producto = productoRepository.findById(idProduct).orElse(null);
        producto.setNombreProducto(product.getProductName());
        producto.setDescripcionProducto(product.getProductDescription());
        producto.setStockProducto(product.getProductStock());
        producto.setPrecioProducto(product.getProductPrice());
        producto.setIdCategoria(product.getCategoryId());
        producto.setCodigoBarraProducto(product.getBarcode());

        return productMapper.toProduct(productoRepository.save(producto));

    }


}
