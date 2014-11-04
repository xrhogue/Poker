package com.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.poker.annotation.HandRule;
import com.poker.model.Card.Value;
import com.poker.util.PokerUtil;

public class Hand implements Comparable<Hand>
{    
    List<Card>  cards = new ArrayList<Card>();
    
    public Hand()
    {        
    }
    
    public Hand(final List<Card> cards)
    {
        this.cards.addAll(cards);
        
        sort();
    }
    
    public void addCard(final Card card)
    {
        if (card != null)
        {
            cards.add(card);
        }
        
        sort();
    }
    
    public List<Card> getCards()
    {
        return cards;
    }
    
    /**
     * A variant hand that might involve an ace-low straight; if no ace is present, just return the normal cards
     * @return the variant hand
     */
    public List<Card> getVariant()
    {
        List<Card>  cardVariants = new ArrayList<Card>();
        
        cardVariants.addAll(cards);
        
        for (Card card : cardVariants)
        {
            card.setUseVariant(true);
        }
        
        Collections.sort(cardVariants);
        Collections.reverse(cardVariants);
        
        for (Card card : cardVariants)
        {
            card.setUseVariant(false);
        }        
        
        return cardVariants;
    }

    public HandRule.Type getType()
    {
        return PokerUtil.getType(this);
    }
    
    public Boolean hasAce()
    {
        for (Card card : cards)
        {
            if (card.getValue().equals(Value.ACE))
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public int compareTo(Hand hand)
    {
        return this.getType() != hand.getType() ? this.getType().compareTo(hand.getType()) : PokerUtil.compareSameType(this, hand);
    }

    private void sort()
    {
        Collections.sort(cards);
        Collections.reverse(cards);
    }
}
