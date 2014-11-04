package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(type=Type.FLUSH)
public class FlushRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isFlush(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        return compareHighToLow(hand1, hand2);
    }
}
