package org.simple.builder.model.meta.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.meta.basic.Attributes;
import org.simple.builder.model.meta.basic.BaseSize;
import org.simple.builder.model.meta.basic.D6Check;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Weapon;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Infantry extends CoreFighter {

    private final BaseSize baseSize;
    private final D6Check save;

    @Builder
    public Infantry(String name, List<Weapon> weapons, Movement movement, List<Attributes> specials, BaseSize baseSize, D6Check save) {
        super(name, weapons, movement, specials);
        this.baseSize = baseSize;
        this.save = save;
    }
}
