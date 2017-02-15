package org.simple.builder.model.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Formation extends AbstractWargameEntity {

    private String name;
    private String metaId;
}
