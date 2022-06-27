package com.store.persistence.mapper;

import com.store.domain.dto.Product;
import com.store.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombreProducto", target = "productName"),
            @Mapping(source = "descripcionProducto", target = "productDescription"),
            @Mapping(source = "precioProducto", target = "productPrice"),
            @Mapping(source = "stockProducto", target = "productStock"),
            @Mapping(source = "estadoProducto", target = "productStatus"),
            @Mapping(source = "codigoBarraProducto", target = "barcode"),
            @Mapping(source = "idCategoria", target = "categoryId"),
    })
    Product toProduct(Producto producto);
    List<Product> toProductList(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "categoria", ignore = true)
    Producto toProducto(Product product);




}
