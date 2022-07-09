package productfilter;

import productfilter.model.Labor;
import productfilter.model.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class ProductSellService<T> {
//    private final PartManagementService partManagementService;
//
//    public List<Part> filterByType(List<Part> parts) {
//        return partManagementService.findProductByType(parts);
//    }

    private final ProductManagement<T> productManagement;

    public List<T> filterByType(List<T> products){
        return productManagement.findProductByType(products);
    }

}
