package productfilter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

public interface ProductManagement<T> {
    List<T> findProductByType(List<T> products);
}
