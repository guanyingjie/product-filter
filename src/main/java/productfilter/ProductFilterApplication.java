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
                        .name("tyre")
                        .build(),
                Part.builder()
                        .type(Part.ProductType.WHEEL)
                        .name("wheel")
                        .build(),
                Part.builder()
                        .type(Part.ProductType.TYRE)
                        .name("tyre2")
                        .build()
        );
        List<Labor> labors = List.of(
                Labor.builder()
                        .type(Labor.LaborType.INSTALL)
                        .name("install")
                        .build(),
                Labor.builder()
                        .type(Labor.LaborType.REPAIR)
                        .name("repair")
                        .build(),
                Labor.builder()
                        .type(Labor.LaborType.INSTALL)
                        .name("install2")
                        .build()
        );


//        PartManagementService partManagementService = new PartManagementService();
//        ProductSellService productSellService = new ProductSellService(partManagementService);
//        List<Part> filteredParts = productSellService.filterByType(parts);
//        System.out.println("filteredParts " + filteredParts);


        //DIP
        ProductManagement<Labor> productManagement = new LaborManagementService();
        ProductSellService<Labor> productSellService = new ProductSellService<>(productManagement);
        List<Labor> filteredParts = productSellService.filterByType(labors);
        System.out.println("filteredParts " + filteredParts);
    }

}
