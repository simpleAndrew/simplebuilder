package org.simple.builder.model.meta;

import lombok.Data;
import org.simple.builder.model.ConflictSide;

@Data
public class AbstractWargameEntity {

    private String name;
    private String metaId;
    private ConflictSide side;

}
