package com.store.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private Long categoryId;
    private String categoryName;
    private Boolean categoryStatus;
}
