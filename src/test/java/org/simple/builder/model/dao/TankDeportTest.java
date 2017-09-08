package org.simple.builder.model.dao;

import org.junit.Test;
import org.simple.builder.model.meta.core.Tank;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TankDeportTest {

    @Test
    public void shouldReturnPz3Profile() throws Exception {
        //given
        TankDeport tankDeport = new TankDeport();

        //when
        Optional<Tank> pz3 = tankDeport.getTankProfile("pz3");

        //then
        assertTrue(pz3.isPresent());
        assertEquals(4, pz3.get().getWeapons().size());
    }
}