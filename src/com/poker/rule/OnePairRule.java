package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(rank=7, type=Type.ONE_PAIR)
public class OnePairRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isOnePair(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        int compare = compareMaxCountValue(hand1, hand2);
        
        if (compare == 0)
        {
            return compareHighToLow(hand1, hand2);
        }
        
        return compare;
    }
}
