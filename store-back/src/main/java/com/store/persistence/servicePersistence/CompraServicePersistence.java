package com.store.persistence.servicePersistence;

import com.store.domain.dto.Purchase;
import com.store.domain.repository.PurchaseRepository;
import com.store.persistence.entity.Compra;
import com.store.persistence.mapper.PurchaseMapper;
import com.store.persistence.repositoryPersistence.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraServicePersistence implements PurchaseRepository {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<Purchase> findAll() {
        return purchaseMapper.toPurchaseList(compraRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClientId(String idClient) {
        return compraRepository.findByIdCliente(idClient).map(purchases -> purchaseMapper.toPurchaseList(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getComprasProducto().forEach(compraProducto -> compraProducto.setCompra(compra));
        return purchaseMapper.toPurchase(compraRepository.save(compra));
    }

    @Override
    public boolean delete(Long idPurchase) {
        try {
            compraRepository.deleteById(idPurchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Purchase> getById(Long id) {
        return compraRepository.findById(id).map(purchase -> purchaseMapper.toPurchase(purchase));
    }
}
