package org.simple.builder.model.dao;

import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.simple.builder.model.meta.basic.fighter.RateOfFire;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.specials.WeaponsSpecialRule;
import org.simple.builder.model.meta.core.Tank;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.simple.builder.model.meta.basic.Range.ofInches;
import static org.simple.builder.model.meta.basic.types.D6Check.FOUR_PLUS;
import static org.simple.builder.model.meta.basic.types.D6Check.SIX_PLUS;
import static org.simple.builder.model.meta.basic.types.D6Check.THREE_PLUS;

@Service
public class TankDeport {

    public Optional<Tank> getTankProfile(String name) {

        if (name.equalsIgnoreCase("pz3")) {
            return Optional.of(
                    Tank.builder()
                            .name("Panzer III")
                            .chassis(buildChassis())
                            .weapons(buildWeapons())
                            .movement(buildMovement())
                            .build()
            );
        }

        return Optional.empty();
    }

    private Chassis buildChassis() {
        return Chassis.builder()
                .name("pzIII")
                .front(5)
                .side(3)
                .top(1)
                .build();
    }

    private Movement buildMovement() {
        return Movement.builder()
                .tactical(ofInches(10))
                .crossCountryDash(ofInches(18))
                .terrainDash(ofInches(12))
                .roadDash(ofInches(20))
                .crossCheck(THREE_PLUS)
                .build();
    }

    private List<Weapon> buildWeapons() {
        return Arrays.asList(
                Weapon.builder()
                        .name("Panzer III MGs")
                        .range(ofInches(16))
                        .rateOfFire(RateOfFire.mg(4))
                        .antiTankRating(2)
                        .firepower(SIX_PLUS)
                        .build(),
                Weapon.builder()
                        .name("Panzer III 7,5cm")
                        .range(ofInches(24))
                        .rateOfFire(RateOfFire.gun(2))
                        .antiTankRating(9)
                        .firepower(THREE_PLUS)
                        .specials(Collections.singletonList(new WeaponsSpecialRule("HEAT", "Target Armour is not increased for range over 16\"")))
                        .build(),
                Weapon.builder()
                        .name("Panzer III short 5cm")
                        .range(ofInches(24))
                        .rateOfFire(RateOfFire.gun(2))
                        .antiTankRating(8)
                        .firepower(FOUR_PLUS)
                        .build(),
                Weapon.builder()
                        .name("Panzer III long 5cm")
                        .range(ofInches(28))
                        .rateOfFire(RateOfFire.gun(2))
                        .antiTankRating(9)
                        .firepower(FOUR_PLUS)
                        .build()
        );
    }
}
