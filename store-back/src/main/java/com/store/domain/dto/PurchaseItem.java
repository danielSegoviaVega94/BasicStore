package com.store.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItem {

    private Long productId;
    private Integer quantity;
    private BigDecimal totalSale;
    private Boolean status;
}
