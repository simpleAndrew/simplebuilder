package org.simple.builder.magic;

import org.simple.builder.resources.meta.ArmyResource;
import org.springframework.stereotype.Component;

@Component
public class AllMightyProvider implements AllMightyProviderAsItShouldBe {

    public ArmyResource getArmy(String id) {
        ArmyResource armyResource = new ArmyResource();
        armyResource.setMetaId(id);

        return armyResource;
    }
}
