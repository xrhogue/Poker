package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(rank=2, type=Type.FULL_HOUSE)
public class FullHouseRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isFullHouse(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        return compareMaxCountValue(hand1, hand2);
    }
}
