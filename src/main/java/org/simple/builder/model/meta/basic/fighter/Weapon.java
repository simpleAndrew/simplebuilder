package org.simple.builder.model.meta.basic.fighter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simple.builder.model.meta.basic.Range;
import org.simple.builder.model.meta.basic.specials.WeaponsSpecialRule;
import org.simple.builder.model.meta.basic.types.D6Check;
import org.simple.builder.model.meta.core.CoreFighter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Weapon {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private int antiTankRating;
    private D6Check firepower;

    private Type type;

    @Embedded
    private RateOfFire rateOfFire;

    @Embedded
    private Range range;

    @Embedded @AttributeOverrides(
            {
                @AttributeOverride(name = "inches", column = @Column(name = "minimal_inches")),
                @AttributeOverride(name = "centimeters", column = @Column(name = "minimal_centimeters"))
            }
    )
    private Range minimalRange;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<WeaponsSpecialRule> specials = Collections.emptyList();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<CoreFighter> users = Collections.emptyList();


    public enum Type {
        ARTILLERY,
        DIRECT
    }
}
