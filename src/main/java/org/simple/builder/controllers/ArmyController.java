package org.simple.builder.controllers;

import org.simple.builder.model.dao.TankDeport;
import org.simple.builder.model.meta.core.Tank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("armies")
public class ArmyController {

    @Autowired
    private TankDeport deport;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAvailableArmies() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tanks/{tankName}", method = RequestMethod.GET)
    public HttpEntity<Tank> getTank(@PathVariable("tankName") String tankName) {
        Optional<Tank> tankProfile = deport.getTankProfile(tankName);

        return tankProfile.map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
    }

}
