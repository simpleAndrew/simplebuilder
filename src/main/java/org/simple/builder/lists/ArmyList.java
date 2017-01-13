package org.simple.builder.lists;


import lombok.Getter;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class ArmyList extends ResourceSupport {

    private String armyName;

    @JsonCreator
    public ArmyList(@JsonProperty("armyName") String armyName) {
        this.armyName = armyName;
    }
}
