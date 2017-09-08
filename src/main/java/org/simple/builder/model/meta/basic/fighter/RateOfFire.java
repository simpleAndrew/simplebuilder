package org.simple.builder.model.meta.basic.fighter;

import lombok.Value;

@Value
public class RateOfFire {

    int halted;
    int moving;

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
