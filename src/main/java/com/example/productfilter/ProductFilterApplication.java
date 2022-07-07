package com.example.productfilter;

import com.example.productfilter.model.Product;
import com.example.productfilter.specification.ColorFilterSpecification;
import com.example.productfilter.specification.SizeFilterSpecification;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductFilterApplication.class, args);

        var product1 = new Product("RED", "BIG", "BIG RED PRODUCT");
        var product2 = new Product("BLUE", "SMALL", "SMALL BLUE PRODUCT");
        var product3 = new Product("RED", "MEDIUM", "MEDIUM RED PRODUCT");

        var products = List.of(product1, product2, product3);

        var colorFilterSpeficiation = new ColorFilterSpecification("RED");
        var colorFilteredProduct = ProductFilter.filterBy(products, colorFilterSpeficiation);
        var colorFilteredProductName = new ArrayList<>();
        for (var product : colorFilteredProduct) {
            colorFilteredProductName.add(product.name);
        }
        System.out.println("Filtered product from \"" + colorFilterSpeficiation.getProductColor() + "\" filter is : " + colorFilteredProductName);

        var sizeFilterSpecification = new SizeFilterSpecification("SMALL");
        var sizeFilteredProduct = ProductFilter.filterBy(products, sizeFilterSpecification);
        var sizeFilteredProductName = new ArrayList<>();
        for (var product : sizeFilteredProduct) {
            sizeFilteredProductName.add(product.name);
        }
        System.out.println("Filtered product from \"" + sizeFilterSpecification.getProductSize() + "\" filter is : " + sizeFilteredProductName);

        var sizeAndColorFilteredProduct = ProductFilter.filterBy(products, sizeFilterSpecification);
        sizeAndColorFilteredProduct = ProductFilter.filterBy(sizeAndColorFilteredProduct, colorFilterSpeficiation);
        var sizeAndColorFilteredProductName = new ArrayList<>();
        for (var product : sizeAndColorFilteredProduct) {
            sizeAndColorFilteredProductName.add(product.name);
        }
        System.out.println("Filtered product from \"" + sizeFilterSpecification.getProductSize() + "\" and \""
                + colorFilterSpeficiation.getProductColor()
                + "\" filter is : " + sizeAndColorFilteredProductName);

    }

}
