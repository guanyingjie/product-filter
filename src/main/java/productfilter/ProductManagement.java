package productfilter;

import java.util.List;

public interface ProductManagement<T> {
    List<T> findProductByType(List<T> products);
}
