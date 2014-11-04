package com.poker.util;

import com.poker.annotation.HandRule;
import com.poker.model.Hand;
import com.poker.rule.Rule;
import com.poker.rule.factory.RuleFactory;

/**
 * General Poker Utility Class
 * @author rhogue
 *
 */
public class PokerUtil
{
    /**
     * If two hands are of the same type, we need to compare them using the rule the hands matched on.
     * @param hand1
     * @param hand2
     * @return the comparison value
     */
    public static int compareSameType(final Hand hand1, final Hand hand2)
    {
        Rule rule = RuleFactory.getRule(hand1.getType());

        return rule.compareTo(hand1, hand2);
    }
    
    /**
     * Get the Hand Type based on which rule the hand matches
     * @param hand the hand to match
     * @return the type
     */
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
