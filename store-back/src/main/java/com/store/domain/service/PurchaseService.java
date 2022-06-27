package com.store.domain.service;

import com.store.domain.dto.Purchase;
import com.store.domain.repository.PurchaseRepository;
import com.store.persistence.servicePersistence.CompraServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CompraServicePersistence purchaseServicePersistence;

    public List<Purchase> getAll(){
        return purchaseRepository.findAll();
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public boolean delete(Long id){
        try {
           //find by id
              Purchase purchase = purchaseRepository.getById(id).orElse(null);
            assert purchase != null;
            purchase.setStatus(false);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Purchase> getById(Long id){
        return purchaseRepository.getById(id);
    }

    public Optional<List<Purchase>> getByClientId(String idClient){
        return purchaseRepository.getByClientId(idClient);
    }
}
