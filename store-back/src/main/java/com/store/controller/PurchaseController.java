package com.store.controller;

import com.store.domain.dto.Purchase;
import com.store.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/purchase" )
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(value = "")
    public ResponseEntity<List<Purchase>> getAll() {
        // if empty return no content
        if (purchaseService.getAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping(value = "/{idPurchase}")
    public ResponseEntity<Optional<Purchase>> getById(@PathVariable Long idPurchase) {
        // if empty return no content
        if (purchaseService.getById(idPurchase).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(purchaseService.getById(idPurchase));
    }

    @GetMapping(value = "/client/{idClient}")
    public ResponseEntity<Optional<List<Purchase>>> getByClientId(@PathVariable String idClient) {
        // if empty return no content
        if (purchaseService.getByClientId(idClient).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(purchaseService.getByClientId(idClient));
    }

    @PostMapping("")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.save(purchase));
    }

    @DeleteMapping("/{idPurchase}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idPurchase) {
        return ResponseEntity.ok(purchaseService.delete(idPurchase));
    }



}
