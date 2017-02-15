package org.simple.builder.model.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Army extends AbstractWargameEntity{

    private List<Formation> availableFormations;
    private List<Unit> availableSupport;
}
