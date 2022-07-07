package com.example.productfilter;

import com.example.productfilter.model.Labor;
import com.example.productfilter.model.Part;
import com.example.productfilter.specification.LaborManagementService;
import com.example.productfilter.specification.PartManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSellService {
    private final PartManagementService partManagementService;
    private final LaborManagementService laborManagementService;

    public BigDecimal calculatePartPrice(List<Part> parts) {
        return BigDecimal.valueOf(partManagementService.findProductByType(parts).
                stream().
                map(Part::getPrice)
                .count());
    }
    public BigDecimal calculateLaborPrice(List<Labor> labors) {
        return BigDecimal.valueOf(laborManagementService.findProductByType(labors).
                stream().
                map(Labor::getPrice)
                .count());
    }
}
