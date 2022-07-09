package productfilter.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class Part {
    public String name;
    public ProductType type;

    public enum ProductType{
        TYRE,
        WHEEL
    }
}
