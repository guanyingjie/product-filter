package productfilter;

import productfilter.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartManagementService implements ProductManagement<Part>{
    @Override
    public List<Part> findProductByType(List<Part> parts) {
        return parts.stream()
                .filter(product -> Part.ProductType.TYRE.equals(product.type))
                .collect(Collectors.toList());
    }
}
