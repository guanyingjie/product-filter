package productfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ParserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import productfilter.model.Labor;
import productfilter.model.Part;

import java.math.BigDecimal;
import java.util.List;

public class ProductSellServiceIntegrationTest extends IntegrationTestBase{
    @Autowired
    private PartManagementService partManagementService;

    @Autowired
    private LaborManagementService laborManagementService;

    @Autowired
    private ProductSellService productSellService;

    @BeforeEach
    public void setUp(){
        super.setUp();
    }
    @Test
    void test(){
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
    }
}
