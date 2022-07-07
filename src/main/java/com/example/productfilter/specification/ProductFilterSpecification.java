package com.example.productfilter.specification;

import com.example.productfilter.model.Product;

import java.util.List;

public interface ProductFilterSpecification {
    List<Product> applyFilter(List<Product> products);
}