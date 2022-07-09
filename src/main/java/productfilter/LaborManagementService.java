package productfilter;

import productfilter.model.Labor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//public class LaborManagementService {
//
//    public List<Labor> findProductByType(List<Labor> labors) {
//        return labors.stream()
//                .filter(labor -> Labor.LaborType.INSTALL.equals(labor.type))
//                .collect(Collectors.toList());
//    }
//}

public class LaborManagementService implements ProductManagement<Labor> {

    @Override
    public List<Labor> findProductByType(List<Labor> products) {
        return products.stream()
                .filter(labor -> Labor.LaborType.INSTALL.equals(labor.type))
                .collect(Collectors.toList());
    }
}
