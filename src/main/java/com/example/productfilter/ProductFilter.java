package com.example.productfilter;

import com.example.productfilter.model.Product;
import com.example.productfilter.specification.ProductFilterSpecification;

import java.util.List;

public class ProductFilter {

    public static List<Product> filterBy(
            List<Product> products,
            ProductFilterSpecification filterSpecification
    ) {
        return filterSpecification.applyFilter(products);
    }
}