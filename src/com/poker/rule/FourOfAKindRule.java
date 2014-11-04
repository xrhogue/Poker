package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(rank=1, type=Type.FOUR_OF_A_KIND)
public class FourOfAKindRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isFourOfAKind(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        return compareMaxCountValue(hand1, hand2);
    }
}
