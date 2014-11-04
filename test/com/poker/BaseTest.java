package com.poker;

import java.util.ArrayList;
import java.util.List;

import com.poker.model.Card;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class BaseTest
{
    protected List<Card> getStraightFlush()
    {
        return getStraightFlush(Value.SEVEN, Suit.CLUB);
    }
    
    protected List<Card> getStraightFlush(final Value startingValue, final Suit suit)
    {
        return getStraight(startingValue, suit);
    }
    
    protected List<Card> getFourOfAKind()
    {
        return getFourOfAKind(Value.JACK, Value.SEVEN);
    }
    
    protected List<Card> getFourOfAKind(final Value match, final Value extra)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, match));
        cards.add(new Card(Suit.DIAMOND, match));
        cards.add(new Card(Suit.HEART, match));
        cards.add(new Card(Suit.SPADE, match));
        cards.add(new Card(Suit.SPADE, extra));
        
        return cards;
    }
    
    protected List<Card> getFullHouse()
    {
        return getFullHouse(Value.JACK, Value.SEVEN);
    }
    
    protected List<Card> getFullHouse(final Value three, final Value two)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, three));
        cards.add(new Card(Suit.DIAMOND, three));
        cards.add(new Card(Suit.HEART, three));
        cards.add(new Card(Suit.SPADE, two));
        cards.add(new Card(Suit.DIAMOND, two));
        
        return cards;
    }
    
    protected List<Card> getFlush()
    {
        return getFlush(Suit.CLUB);
    }
    
    protected List<Card> getFlush(final Suit suit)
    {
        return getFlush(suit, Value.SEVEN);
    }
    
    protected List<Card> getFlush(final Suit suit, final Value last)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(suit, Value.QUEEN));
        cards.add(new Card(suit, Value.EIGHT));
        cards.add(new Card(suit, Value.FOUR));
        cards.add(new Card(suit, Value.NINE));
        cards.add(new Card(suit, last));
        
        return cards;
    }
   
    protected List<Card> getStraight()
    {
        return getStraight(Value.SEVEN);
    }
    
    protected List<Card> getStraight(final Value startingValue)
    {
        return getStraight(startingValue, null);
    }
    
    protected List<Card> getStraight(final Value startingValue, final Suit suit)
    {
        List<Card>  cards = new ArrayList<Card>();
        Integer     count = 0;
        
        for (Value value : Value.values())
        {
            if (value != startingValue && count == 0)
            {
                continue;
            }
            
            cards.add(new Card(suit == null ? Suit.values()[count % Suit.values().length] : suit, value));
            count++;
            
            if (count == 5)
            {
                break;
            }
        }
        
        return cards;
    }
    
    protected List<Card> getThreeOfAKind()
    {
        return getThreeOfAKind(Value.KING, Value.NINE, Value.FIVE);
    }
    
    protected List<Card> getThreeOfAKind(final Value match, final Value extra1, final Value extra2)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, match));
        cards.add(new Card(Suit.DIAMOND, match));
        cards.add(new Card(Suit.HEART, match));
        cards.add(new Card(Suit.CLUB, extra1));
        cards.add(new Card(Suit.SPADE, extra2));
        
        return cards;
    }
    
    protected List<Card> getTwoPair()
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, Value.JACK));
        cards.add(new Card(Suit.HEART, Value.JACK));
        cards.add(new Card(Suit.CLUB, Value.NINE));
        cards.add(new Card(Suit.DIAMOND, Value.NINE));
        cards.add(new Card(Suit.SPADE, Value.SEVEN));
        
        return cards;
    }
    
    protected List<Card> getOnePair()
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, Value.JACK));
        cards.add(new Card(Suit.HEART, Value.JACK));
        cards.add(new Card(Suit.CLUB, Value.NINE));
        cards.add(new Card(Suit.DIAMOND, Value.EIGHT));
        cards.add(new Card(Suit.SPADE, Value.SEVEN));
        
        return cards;
    }
    
    protected List<Card> getHighCard()
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, Value.JACK));
        cards.add(new Card(Suit.HEART, Value.FOUR));
        cards.add(new Card(Suit.CLUB, Value.NINE));
        cards.add(new Card(Suit.DIAMOND, Value.EIGHT));
        cards.add(new Card(Suit.SPADE, Value.SEVEN));
        
        return cards;
    }

}
