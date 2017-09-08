package org.simple.builder.model.meta.basic;


import lombok.Data;

@Data
public class Range {

    private final int inches;
    private final int cantimiters;

    public static Range ofInches(int range) {
        return new Range(range, (int)(range * 2.5));
    }

}
