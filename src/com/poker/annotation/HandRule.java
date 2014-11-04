package com.poker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The HandRule annotation is used to identify rules for matching hands, and comparing hands of the same type.
 * The Type Enum is associated with each rule, and its ordinal also is used to determing ranking among the rules;
 * higher ranked types are matched first, and the matching continues to the lower ranked types until successful.
 * The last type is always the default.
 * 
 * @author rhogue
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HandRule
{
    public enum Type
    {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH
    };

    Type type();
}
