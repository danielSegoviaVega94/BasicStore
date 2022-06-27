package com.store.persistence.repositoryPersistence;

import com.store.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByIdCategoria(Integer idCategoria);
    //find product when stock < 20
    List<Producto> findByStockProductoLessThan(Integer stockProducto);

    Producto findByNombreProducto(String nombreProducto);
}
