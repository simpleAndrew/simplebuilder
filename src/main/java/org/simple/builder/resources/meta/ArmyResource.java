package org.simple.builder.resources.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.simple.builder.model.ConflictSide;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArmyResource extends ResourceSupport {

    private ConflictSide side;

    private String nation;
    private String name;
    private String metaId;

    private List<FormationResource> availableFormations;
    private List<UnitResource> availableSupport;
}
