package com.poker.rule;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;

@HandRule(type=Type.THREE_OF_A_KIND)
public class ThreeOfAKindRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isThreeOfAKind(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        return compareMaxCountValue(hand1, hand2);
    }
}
