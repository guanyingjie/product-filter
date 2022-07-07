package com.example.productfilter.specification;

import com.example.productfilter.model.Labor;
import com.example.productfilter.model.Part;

import java.util.List;
import java.util.stream.Collectors;

public class LaborManagementService {

    public List<Labor> findProductByType(List<Labor> labors) {
        return labors.stream()
                .filter(labor -> Labor.LaborType.INSTALL.equals(labor.type))
                .collect(Collectors.toList());
    }
}
