package com.example.productfilter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Labor {
    public BigDecimal price;
    public LaborType type;

    public enum LaborType{
        INSTALL,
        REPAIR
    }
}
