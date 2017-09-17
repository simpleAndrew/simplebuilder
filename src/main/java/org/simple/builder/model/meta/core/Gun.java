package org.simple.builder.model.meta.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.types.BaseSize;
import org.simple.builder.model.meta.basic.types.D6Check;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="team_type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("gun")
public class Gun extends CoreFighter {

    private final BaseSize baseSize;
    private final D6Check save;

    @Builder
    public Gun(Long id, String name, List<Weapon> weapons, Movement movement, BaseSize baseSize, D6Check save) {
        super(id, name, weapons, movement);
        this.baseSize = baseSize;
        this.save = save;
    }
}
