package com.store.domain.repository;

import com.store.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> findAll();
    Optional<List<Purchase>> getByClientId(String idClient);
    Purchase save(Purchase purchase);
    boolean delete(Long idPurchase);
    Optional<Purchase> getById(Long id);
}
