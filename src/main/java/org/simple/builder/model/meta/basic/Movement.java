package org.simple.builder.model.meta.basic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movement {

    private final Range crossCountryDash;
    private final Range terrainDash;
    private final Range roadDash;

    private Range tactical;

    private D6Check crossCheck;
}
