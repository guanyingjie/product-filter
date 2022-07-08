package productfilter;

import productfilter.model.Labor;
import productfilter.model.Part;
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
        return partManagementService.findProductByType(parts).
                stream().
                map(Part::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    public BigDecimal calculateLaborPrice(List<Labor> labors) {
        return laborManagementService.findProductByType(labors).
                stream().
                map(Labor::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
