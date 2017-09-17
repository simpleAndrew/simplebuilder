package org.simple.builder.model.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.builder.model.meta.basic.Range;
import org.simple.builder.model.meta.basic.fighter.RateOfFire;
import org.simple.builder.model.meta.basic.fighter.Weapon;
import org.simple.builder.model.meta.basic.specials.SpecialRule;
import org.simple.builder.model.meta.basic.specials.WeaponsSpecialRule;
import org.simple.builder.model.meta.basic.types.D6Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WeaponRepoTest {

    @Autowired
    private WeaponRepo repo;

    @Autowired
    private SpecialRulesRepo specialsRepo;

    @Test
    public void shouldSaveWeapon() {
        //given
        Weapon kwk = buildKwK();

        //when
        repo.save(kwk);

        //then
        Weapon foundWeapon = repo.findOne(kwk.getId());
        assertThat(foundWeapon).isNotNull();
    }

    @Test
    public void shouldSaveArtillery() {
        //given
        Range expectedMinimalRange = Range.ofInches(8);
        Weapon.Type expectedType = Weapon.Type.ARTILLERY;

        Weapon kwk = buildKwK();
        kwk.setType(expectedType);
        kwk.setMinimalRange(expectedMinimalRange);

        //when
        repo.save(kwk);

        //then
        Weapon foundWeapon = repo.findOne(kwk.getId());
        assertThat(foundWeapon).isNotNull();
        assertThat(foundWeapon.getType()).isEqualTo(expectedType);
        assertThat(foundWeapon.getMinimalRange()).isEqualTo(expectedMinimalRange);
    }

    @Test
    @Transactional
    public void shouldCreateSpecialRuleWhenWeaponIsCreated() throws Exception {
        //given
        Weapon toSave = buildKwK();
        WeaponsSpecialRule heat = new WeaponsSpecialRule("HEAT", "Do not increase armour when hit on long range");

        //when
        toSave.setSpecials(Collections.singletonList(heat));
        repo.save(toSave);
        Set<SpecialRule> heats = specialsRepo.findByName("HEAT");

        //then
        assertThat(heats).isNotEmpty();
        assertThat(heats).contains(heat);
    }

    private Weapon buildKwK() {
        return Weapon.builder()
                .name("5 cm KwK 38 L/42")
                .antiTankRating(8)
                .firepower(D6Check.FOUR_PLUS)
                .rateOfFire(RateOfFire.gun(2))
                .range(Range.ofInches(24))
                .build();
    }

}