package org.simple.builder.model.meta.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.specials.FightersSpecialRule;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public abstract class CoreFighter {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Movement movement;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Weapon> weapons;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<FightersSpecialRule> specialRules;
}
