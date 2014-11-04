package com.poker.model;

public class Card implements Comparable<Card>
{
    public enum Suit
    {
        CLUB,
        HEART,
        DIAMOND,
        SPADE
    }
    
    public enum Value
    {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(1,14);
        
        private Integer lowValue;
        private Integer highValue;
        
        private Value(final Integer value)
        {
            this.lowValue = value;
            this.highValue = value;
        }
        
        private Value(final Integer lowValue, final Integer highValue)
        {
            this.lowValue = lowValue;
            this.highValue = highValue;
        }
        
        public Boolean isMultiValued()
        {
            return lowValue != highValue;
        }
        
        public Integer getValue()
        {
            return isMultiValued() ? -1 : lowValue;
        }
        
        public Integer getLowValue()
        {
            return lowValue;
        }
        
        public Integer getHighValue()
        {
            return highValue;
        }
    }
    
    private Suit    suit;
    private Value   value;
    private Boolean useSuitRanking = false;
    
    public Card(final Suit suit, final Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public Value getValue()
    {
        return value;
    }

    @Override
    public int compareTo(Card card)
    {
        if (this.value.getValue() > card.value.getValue())
        {
            return 1;
        }
        else if (this.value.getValue() < card.value.getValue())
        {
            return -1;
        }
        else if (useSuitRanking && this.suit.ordinal() > card.suit.ordinal())
        {
            return 1;
        }
        else if (useSuitRanking && this.suit.ordinal() < card.suit.ordinal())
        {
            return -1;
        }
        
        return 0;
    }
}
