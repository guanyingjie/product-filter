package com.example.productfilter.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Part {
    public BigDecimal price;
    public ProductType type;

    public enum ProductType{
        TYRE,
        WHEEL
    }
}
