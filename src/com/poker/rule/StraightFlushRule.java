package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(rank=0, type=Type.STRAIGHT_FLUSH)
public class StraightFlushRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isStraightFlush(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        return compareHighToLow(hand1, hand2);
    }
}
