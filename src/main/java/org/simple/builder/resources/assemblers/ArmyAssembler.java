package org.simple.builder.resources.assemblers;

import org.simple.builder.controllers.ArmyController;
import org.simple.builder.model.meta.Army;
import org.simple.builder.resources.meta.ArmyResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ArmyAssembler extends ResourceAssemblerSupport<Army, ArmyResource> {


    public ArmyAssembler() {
        super(ArmyController.class, ArmyResource.class);
    }

    @Override
    public ArmyResource toResource(Army entity) {
        return createResourceWithId(entity.getMetaId(), entity);
    }
}
