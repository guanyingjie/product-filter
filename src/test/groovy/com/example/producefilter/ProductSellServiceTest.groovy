package com.example.producefilter

import productfilter.LaborManagementService
import productfilter.PartManagementService
import productfilter.ProductSellService
import productfilter.model.Labor
import productfilter.model.Part
import spock.lang.Specification

class ProductSellServiceTest extends Specification {
    def partManagement = Mock(PartManagementService)
    def laborManagement = Mock(LaborManagementService)

    def produceSellService = new ProductSellService(partManagement, laborManagement)

    def "calculate part price"() {
        given:
        def parts = List.of(
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
                        .build(),
        )
        def labors = List.of(
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
                        .build(),
        )
        when:
        BigDecimal totalPrice = produceSellService.calculateLaborPrice(labors).add(produceSellService.filterByTypr(parts))

        then:
        totalPrice == 1000
    }
}
