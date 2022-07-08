package productfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import productfilter.model.Labor;
import productfilter.model.Part;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class ProductFilterApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductFilterApplication.class, args);
        List<Part> parts = List.of(
                Part.builder()
                        .type(Part.ProductType.TYRE)
                        .price(BigDecimal.valueOf(100.23))
                        .build(),
                Part.builder()
                        .type(Part.ProductType.WHEEL)
                        .price(BigDecimal.valueOf(1033.23))
                        .build(),
                Part.builder()
                        .type(Part.ProductType.TYRE)
                        .price(BigDecimal.valueOf(10.23))
                        .build()
        );
        List<Labor> labors = List.of(
                Labor.builder()
                        .type(Labor.LaborType.INSTALL)
                        .price(BigDecimal.valueOf(100.23))
                        .build(),
                Labor.builder()
                        .type(Labor.LaborType.REPAIR)
                        .price(BigDecimal.valueOf(100.23))
                        .build(),
                Labor.builder()
                        .type(Labor.LaborType.INSTALL)
                        .price(BigDecimal.valueOf(100.23))
                        .build()
        );
        LaborManagementService laborManagementService = new LaborManagementService();
        PartManagementService partManagementService = new PartManagementService();
        ProductSellService productSellService = new ProductSellService(partManagementService, laborManagementService);

        BigDecimal price = productSellService.calculateLaborPrice(labors);

        System.out.println("price " + price);
    }

}
