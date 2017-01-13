package org.simple.builder.controllers;

import org.simple.builder.lists.ArmyList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ArmyController {

    @RequestMapping("/army-list")
    public HttpEntity<ArmyList> getList(
            @RequestParam(name = "name", required = false, defaultValue = "USSR") String name) {

        ArmyList armyList = new ArmyList(name);
        armyList.add(linkTo(methodOn(ArmyController.class).getList(name)).withSelfRel());

        return new ResponseEntity<>(armyList, HttpStatus.OK);
    }
}
