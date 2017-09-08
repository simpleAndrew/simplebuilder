package org.simple.builder.model.meta.basic;

public enum D6Check {

    ONE_PLUS,
    TWO_PLUS,
    THREE_PLUS,
    FOUR_PLUS,
    FIVE_PLUS,
    SIX_PLUS;

    @Override
    public String toString() {
        return (this.ordinal() + 1) + "+";
    }
}
