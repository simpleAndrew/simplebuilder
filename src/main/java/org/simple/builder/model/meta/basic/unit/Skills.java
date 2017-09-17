package org.simple.builder.model.meta.basic.unit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple.builder.model.meta.basic.types.D6Check;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Skills {

    private D6Check skill;
    private D6Check assault;
    private D6Check isHitOn;
}
