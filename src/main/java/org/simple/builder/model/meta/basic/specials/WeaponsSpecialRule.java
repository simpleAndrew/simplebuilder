package org.simple.builder.model.meta.basic.specials;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simple.builder.model.meta.basic.fighter.Weapon;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"weapons"})

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="owner_type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("weapon")
public class WeaponsSpecialRule extends SpecialRule {

    public WeaponsSpecialRule(String name, String description) {
        super(name, description);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Weapon> weapons;
}
