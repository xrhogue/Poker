package com.poker.util;

import com.poker.annotation.HandRule;
import com.poker.model.Hand;
import com.poker.rule.Rule;
import com.poker.rule.factory.RuleFactory;

public class PokerUtil
{
    public static int compareSameType(final Hand hand1, final Hand hand2)
    {
        Rule rule = RuleFactory.getRule(hand1.getType());

        return rule.compareTo(hand1, hand2);
    }
    
    public static HandRule.Type getType(final Hand hand)
    {
        for (Rule rule :  RuleFactory.getRules())
        {
            if (rule.matches(hand))
            {
                return rule.getType();
            }
        }
        
        return RuleFactory.getDefaultRule().getType();
    }
}
