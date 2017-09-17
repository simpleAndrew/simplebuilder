package org.simple.builder.model.meta.basic.unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple.builder.model.meta.basic.types.D6Check;

import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Morale {

    private D6Check morale;
    private D6Check lastStand;
    private D6Check remount;
    private D6Check counterattack;

}
