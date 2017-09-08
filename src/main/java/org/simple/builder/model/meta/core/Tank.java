package org.simple.builder.model.meta.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.meta.basic.Attributes;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.simple.builder.model.meta.basic.fighter.Weapon;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tank extends CoreFighter {

    private final Chassis chassis;

    @Builder
    private Tank(String name, List<Weapon> weapons, Movement movement, List<Attributes> specials, Chassis chassis) {
        super(name, weapons, movement, specials);
        this.chassis = chassis;
    }
}
