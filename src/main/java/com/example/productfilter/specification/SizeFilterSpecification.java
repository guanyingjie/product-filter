package com.example.productfilter.specification;

import com.example.productfilter.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SizeFilterSpecification implements ProductFilterSpecification {
    private final String productSize;

    public SizeFilterSpecification(String productSize) {
        this.productSize = productSize;
    }

    public String getProductSize() {
        return productSize;
    }

    @Override
    public List<Product> applyFilter(List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.size.equals(productSize)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
