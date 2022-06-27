package com.store.domain.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Purchase {

    private Long idPurchase;
    private Long datePurchase;
    private Integer idClient;
    private String paymentMethod;
    private String comment;
    private Boolean status;
    private List<PurchaseItem> purchaseItems;

}
