package org.simple.builder.model.meta.basic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Range {

    private int inches;
    private int centimeters;

    public static Range ofInches(int range) {
        return new Range(range, (int)(range * 2.5));
    }

}
