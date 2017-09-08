package org.simple.builder.model.meta.basic.unit;

import lombok.Builder;
import lombok.Data;
import org.simple.builder.model.meta.basic.D6Check;

@Data
@Builder
public class Morale {

    private final D6Check morale;
    private final D6Check lastStand;
    private final D6Check remount;
    private final D6Check counterattack;

}
