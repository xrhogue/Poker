package com.poker.rule;

import java.util.List;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Card;
import com.poker.model.Hand;

@HandRule(type=Type.STRAIGHT)
public class StraightRule extends Rule
{
    @Override
    public Boolean matches(Hand hand)
    {
        return isStraight(hand);
    }

    @Override
    public Integer compareTo(Hand hand1, Hand hand2)
    {
        List<Card>  cards1 = hand1.getCards();
        List<Card>  cards2 = hand2.getCards();
        
        if (isVariant(hand1))
        {
            cards1 = hand1.getVariant();
        }
        
        if (isVariant(hand2))
        {
            cards2 = hand2.getVariant();
        }

        return compareHighToLow(cards1, cards2);
    }
    
    private Boolean isVariant(final Hand hand)
    {
        List<Card>  cards = hand.getCards();
        
        for (int index = 0; index < cards.size() - 1; index++)
        {
            if (cards.get(index).getValue().getRank() != cards.get(index + 1).getValue().getRank() + 1)
            {
                return true;
            }
        }
        
        return false;
    }
}
