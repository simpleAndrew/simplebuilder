package org.simple.builder.model.meta.basic.fighter;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chassis {

    private final String name;

    private final int front;
    private final int side;
    private final int top;

}
