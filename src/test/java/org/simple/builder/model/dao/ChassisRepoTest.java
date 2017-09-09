package org.simple.builder.model.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.builder.model.meta.basic.fighter.Chassis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test-application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ChassisRepoTest {

    @Autowired
    ChassisRepo repo;

    @Test
    public void shouldCreateChassis() {
        //given
        Chassis panther = buildPanther();

        //when
        Chassis save = repo.save(panther);

        //then
        assertThat(save.getId()).isNotNull();
    }

    @Test
    public void shouldSearchChassisByName() {
        //given
        Chassis chassis = buildPanther();
        assertThat(repo.findByName(chassis.getName())).isNull();

        //when
        repo.save(chassis);

        //then
        Chassis foundPanther = repo.findByName("Panther");
        assertThat(foundPanther).hasNoNullFieldsOrProperties();

    }

    private Chassis buildPanther() {
        return Chassis.builder().front(10).side(5).top(1).name("Panther").build();
    }

}