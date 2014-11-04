package com.poker;

import java.util.ArrayList;
import java.util.List;

import com.poker.model.Card;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class BaseTest
{
    public static final Card TwoOfSpades = new Card(Suit.SPADE, Value.TWO);
    public static final Card ThreeOfSpades = new Card(Suit.SPADE, Value.THREE);
    public static final Card FourOfSpades = new Card(Suit.SPADE, Value.FOUR);
    public static final Card FiveOfSpades = new Card(Suit.SPADE, Value.FIVE);
    public static final Card SixOfSpades = new Card(Suit.SPADE, Value.SIX);
    public static final Card SevenOfSpades = new Card(Suit.SPADE, Value.SEVEN);
    public static final Card EightOfSpades = new Card(Suit.SPADE, Value.EIGHT);
    public static final Card NineOfSpades = new Card(Suit.SPADE, Value.NINE);
    public static final Card TenOfSpades = new Card(Suit.SPADE, Value.TEN);
    public static final Card JackOfSpades = new Card(Suit.SPADE, Value.JACK);
    public static final Card QueenOfSpades = new Card(Suit.SPADE, Value.QUEEN);
    public static final Card KingOfSpades = new Card(Suit.SPADE, Value.KING);
    public static final Card AceOfSpades = new Card(Suit.SPADE, Value.ACE);
    public static final Card TwoOfDiamonds = new Card(Suit.DIAMOND, Value.TWO);
    public static final Card ThreeOfDiamonds = new Card(Suit.DIAMOND, Value.THREE);
    public static final Card FourOfDiamonds = new Card(Suit.DIAMOND, Value.FOUR);
    public static final Card FiveOfDiamonds = new Card(Suit.DIAMOND, Value.FIVE);
    public static final Card SixOfDiamonds = new Card(Suit.DIAMOND, Value.SIX);
    public static final Card SevenOfDiamonds = new Card(Suit.DIAMOND, Value.SEVEN);
    public static final Card EightOfDiamonds = new Card(Suit.DIAMOND, Value.EIGHT);
    public static final Card NineOfDiamonds = new Card(Suit.DIAMOND, Value.NINE);
    public static final Card TenOfDiamonds = new Card(Suit.DIAMOND, Value.TEN);
    public static final Card JackOfDiamonds = new Card(Suit.DIAMOND, Value.JACK);
    public static final Card QueenOfDiamonds = new Card(Suit.DIAMOND, Value.QUEEN);
    public static final Card KingOfDiamonds = new Card(Suit.DIAMOND, Value.KING);
    public static final Card AceOfDiamonds = new Card(Suit.DIAMOND, Value.ACE);
    public static final Card TwoOfHearts = new Card(Suit.HEART, Value.TWO);
    public static final Card ThreeOfHearts = new Card(Suit.HEART, Value.THREE);
    public static final Card FourOfHearts = new Card(Suit.HEART, Value.FOUR);
    public static final Card FiveOfHearts = new Card(Suit.HEART, Value.FIVE);
    public static final Card SixOfHearts = new Card(Suit.HEART, Value.SIX);
    public static final Card SevenOfHearts = new Card(Suit.HEART, Value.SEVEN);
    public static final Card EightOfHearts = new Card(Suit.HEART, Value.EIGHT);
    public static final Card NineOfHearts = new Card(Suit.HEART, Value.NINE);
    public static final Card TenOfHearts = new Card(Suit.HEART, Value.TEN);
    public static final Card JackOfHearts = new Card(Suit.HEART, Value.JACK);
    public static final Card QueenOfHearts = new Card(Suit.HEART, Value.QUEEN);
    public static final Card KingOfHearts = new Card(Suit.HEART, Value.KING);
    public static final Card AceOfHearts = new Card(Suit.HEART, Value.ACE);
    public static final Card TwoOfClubs = new Card(Suit.HEART, Value.TWO);
    public static final Card ThreeOfClubs = new Card(Suit.CLUB, Value.THREE);
    public static final Card FourOfClubs = new Card(Suit.CLUB, Value.FOUR);
    public static final Card FiveOfClubs = new Card(Suit.CLUB, Value.FIVE);
    public static final Card SixOfClubs = new Card(Suit.CLUB, Value.SIX);
    public static final Card SevenOfClubs = new Card(Suit.CLUB, Value.SEVEN);
    public static final Card EightOfClubs = new Card(Suit.CLUB, Value.EIGHT);
    public static final Card NineOfClubs = new Card(Suit.CLUB, Value.NINE);
    public static final Card TenOfClubs = new Card(Suit.CLUB, Value.TEN);
    public static final Card JackOfClubs = new Card(Suit.CLUB, Value.JACK);
    public static final Card QueenOfClubs = new Card(Suit.CLUB, Value.QUEEN);
    public static final Card KingOfClubs = new Card(Suit.CLUB, Value.KING);
    public static final Card AceOfClubs = new Card(Suit.CLUB, Value.ACE);
   
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
        return getTwoPair(Value.JACK, Value.NINE, Value.SEVEN);
    }
    
    protected List<Card> getTwoPair(final Value pair1, final Value pair2, final Value extra)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, pair1));
        cards.add(new Card(Suit.HEART, pair1));
        cards.add(new Card(Suit.CLUB, pair2));
        cards.add(new Card(Suit.DIAMOND, pair2));
        cards.add(new Card(Suit.SPADE, extra));
        
        return cards;
    }
   
    protected List<Card> getOnePair()
    {
        return getOnePair(Value.JACK, Value.NINE);
    }
    
    protected List<Card> getOnePair(final Value pair, final Value highCard)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, pair));
        cards.add(new Card(Suit.HEART, pair));
        cards.add(new Card(Suit.CLUB, highCard));
        cards.add(new Card(Suit.DIAMOND, Value.TWO));
        cards.add(new Card(Suit.SPADE, Value.THREE));
        
        return cards;
    }
    
    protected List<Card> getHighCard()
    {
        return getHighCard(Value.TEN);
    }
    
    protected List<Card> getHighCard(final Value highCard)
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.CLUB, highCard));
        cards.add(new Card(Suit.HEART, Value.SIX));
        cards.add(new Card(Suit.CLUB, Value.FOUR));
        cards.add(new Card(Suit.DIAMOND, Value.THREE));
        cards.add(new Card(Suit.SPADE, Value.TWO));
        
        return cards;
    }

}
