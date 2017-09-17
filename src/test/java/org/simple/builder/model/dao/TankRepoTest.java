package org.simple.builder.model.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.builder.model.meta.basic.Movement;
import org.simple.builder.model.meta.basic.Range;
import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.simple.builder.model.meta.basic.fighter.RateOfFire;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.types.D6Check;
import org.simple.builder.model.meta.core.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.simple.builder.model.meta.basic.Range.ofInches;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test-application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TankRepoTest {

    private static final String KWK_LATE_NAME = "5 cm KwK 39 L/60";

    @Autowired
    private TankRepo tankRepo;

    @Autowired
    private WeaponRepo weaponRepo;

    @Test
    @Transactional
    public void shouldSaveTank() {
        //given
        Tank pz3L = buildPz3L();

        //when
        tankRepo.save(pz3L);
        List<Weapon> kwks = weaponRepo.findByName(KWK_LATE_NAME);

        //them
        assertThat(pz3L.getId()).isNotNull();
        assertThat(kwks).hasSize(1);
    }

    private Tank buildPz3L() {
        return Tank.builder()
                .name("Panzer III L")
                .chassis(Chassis.builder()
                        .name("Panzer III")
                        .front(6)
                        .side(3)
                        .top(1)
                        .build())
                .movement(Movement.builder()
                        .tactical(ofInches(10))
                        .terrainDash(ofInches(12))
                        .crossCountryDash(ofInches(18))
                        .roadDash(ofInches(20))
                        .crossCheck(D6Check.THREE_PLUS)
                        .build())
                .weapons(Arrays.asList(
                        Weapon.builder()
                                .name("MGs")
                                .range(ofInches(16))
                                .rateOfFire(RateOfFire.mg(4))
                                .antiTankRating(2)
                                .firepower(D6Check.SIX_PLUS)
                                .build(),
                        Weapon.builder()
                                .name("5 cm KwK 39 L/60")
                                .antiTankRating(8)
                                .firepower(D6Check.FOUR_PLUS)
                                .rateOfFire(RateOfFire.gun(2))
                                .range(Range.ofInches(24))
                                .build()
                ))
                .build();
    }
}