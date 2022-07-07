package com.example.productfilter.specification;

import com.example.productfilter.model.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartManagementService {

    public List<Part> findProductByType(List<Part> parts) {
        return parts.stream()
                .filter(product -> Part.ProductType.TYRE.equals(product.type))
                .collect(Collectors.toList());
    }
}
