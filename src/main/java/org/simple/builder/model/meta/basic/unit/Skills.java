package org.simple.builder.model.meta.basic.unit;

import lombok.Data;
import org.simple.builder.model.meta.basic.D6Check;

@Data
public class Skills {

    private final D6Check skill;
    private final D6Check assault;
    private final D6Check isHitOn;
}
