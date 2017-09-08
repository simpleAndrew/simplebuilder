package org.simple.builder.model.meta.core;

import lombok.Data;
import org.simple.builder.model.meta.basic.Attributes;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Weapon;

import java.util.List;


@Data
public abstract class CoreFighter {

    protected final String name;
    protected final List<Weapon> weapons;
    protected final Movement movement;
    protected final List<Attributes> specials;
}
