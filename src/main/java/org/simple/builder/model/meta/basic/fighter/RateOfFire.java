package org.simple.builder.model.meta.basic.fighter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class RateOfFire {

    private int halted;
    private int moving;

    public static RateOfFire mg(int rof) {
        return new RateOfFire(rof, rof);
    }

    public static RateOfFire gun(int halted) {
        return new RateOfFire(halted, 1);
    }

    public static RateOfFire fastGun(int halted) {
        return new RateOfFire(halted, 2);
    }
}
