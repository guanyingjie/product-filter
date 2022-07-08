package productfilter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class Labor {
    public BigDecimal price;
    public LaborType type;

    public enum LaborType{
        INSTALL,
        REPAIR
    }
}
