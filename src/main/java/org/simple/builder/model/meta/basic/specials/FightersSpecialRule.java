package org.simple.builder.model.meta.basic.specials;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.meta.core.CoreFighter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"fighters"})

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="owner_type", discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("fighter")
public class FightersSpecialRule extends SpecialRule {

    public FightersSpecialRule(String name, String description) {
        super(name, description);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    private List<CoreFighter> fighters;
}
