package org.simple.builder.model.meta;

import lombok.Builder;
import lombok.Data;
import org.simple.builder.model.meta.basic.unit.Morale;
import org.simple.builder.model.meta.basic.unit.Skills;
import org.simple.builder.model.meta.core.CoreFighter;

import java.util.List;

@Data
@Builder
public class Unit {

    private final String name;

    private final Morale morale;
    private final Skills skills;

    private List<CoreFighter> fighters;

}
