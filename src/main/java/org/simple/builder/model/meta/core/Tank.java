package org.simple.builder.model.meta.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.specials.FightersSpecialRule;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="team_type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("tank")
public class Tank extends CoreFighter {

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private final Chassis chassis;

    @Builder
    private Tank(Long id, String name, List<Weapon> weapons, Movement movement, Chassis chassis, List<FightersSpecialRule> specialRules) {
        super(id, name, movement, weapons, specialRules);
        this.chassis = chassis;
    }
}
