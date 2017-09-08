package org.simple.builder.model.meta.basic.fighter;

import lombok.Builder;
import lombok.Data;
import org.simple.builder.model.meta.basic.Attributes;
import org.simple.builder.model.meta.basic.D6Check;
import org.simple.builder.model.meta.basic.Range;

import java.util.List;

@Data
@Builder
public class Weapon {

    private final String name;

    private final Range range;
    private final int antiTankRating;
    private final D6Check firepower;

    private RateOfFire rateOfFire;
    private Range minimalRange;

    private List<Attributes> specials;
}
