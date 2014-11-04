package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(rank=6, type=Type.TWO_PAIR)
public class TwoPairRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isTwoPair(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        int compare = compareCountValues(hand1, hand2);
        
        if (compare == 0)
        {
            return compareHighToLow(hand1, hand2);
        }
        
        return compare;
    }
}
