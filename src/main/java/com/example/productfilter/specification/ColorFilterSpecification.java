package com.example.productfilter.specification;

import com.example.productfilter.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ColorFilterSpecification implements ProductFilterSpecification {
    private final String productColor;

    public ColorFilterSpecification(String productColor) {
        this.productColor = productColor;
    }

    public String getProductColor() {
        return productColor;
    }

    @Override
    public List<Product> applyFilter(List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.color.equals(productColor)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}