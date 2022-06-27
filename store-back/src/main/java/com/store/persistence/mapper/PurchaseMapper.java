package com.store.persistence.mapper;

import com.store.domain.dto.Purchase;
import com.store.persistence.entity.Compra;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
        @Mapping(source = "idCompra", target = "idPurchase"),
        @Mapping(source = "idCliente", target = "idClient"),
        @Mapping(source = "fechaCompra", target = "datePurchase"),
        @Mapping(source = "medioPago", target = "paymentMethod"),
        @Mapping(source = "comentario", target = "comment"),
        @Mapping(source = "estadoCompra", target = "status"),
        @Mapping(source = "comprasProducto", target = "purchaseItems")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchaseList(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
