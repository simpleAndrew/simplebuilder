package org.simple.builder.controllers;

import org.simple.builder.magic.AllMightyProviderAsItShouldBe;
import org.simple.builder.resources.assemblers.ArmyAssembler;
import org.simple.builder.resources.meta.ArmyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("armies")
@ExposesResourceFor(ArmyResource.class)
public class ArmyController {

    @Autowired
    private AllMightyProviderAsItShouldBe provider;

    @Autowired
    private EntityLinks links;

    private final ArmyAssembler armyAssembler = new ArmyAssembler();

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity getAvailableArmies() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{armyId}", method = RequestMethod.GET)
    public HttpEntity<ArmyResource> getArmy(@PathVariable("armyId") String armyId) {

        ArmyResource armyResource = armyAssembler.toResource(provider.getArmy(armyId));

        armyResource.add(
                links.linkToCollectionResource(ArmyResource.class).withRel("armies")
        );


        return new ResponseEntity<>(armyResource, HttpStatus.OK);
    }

}
