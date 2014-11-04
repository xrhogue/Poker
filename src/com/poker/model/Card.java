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
        ACE(14,1);
        
        private Integer variant = null;
        private Integer rank;
        
        private Value(final Integer rank)
        {
            this.rank = rank;
        }
        
        private Value(final Integer rank, final Integer variant)
        {
            this.rank = rank;
            this.variant = variant;
        }
        
        public Boolean hasVariant()
        {
            return variant != null;
        }
        
        public Integer getRank()
        {
            return rank;
        }
        
        public Integer getVariant()
        {
            return variant;
        }
    }
    
    private Suit    suit;
    private Value   value;
    private Boolean useSuitRanking = false; // TODO: implement if suits become important in the poker game beyond determining flush
    private Boolean useVariant = false;
    
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

    public Boolean useVariant()
    {
        return useVariant;
    }

    public void setUseVariant(Boolean useVariant)
    {
        this.useVariant = useVariant;
    }

    @Override
    public int compareTo(Card card)
    {
        if (getRank(this) > getRank(card))
        {
            return 1;
        }
        else if (getRank(this) < getRank(card))
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
    
    private Integer getRank(final Card card)
    {
        if (card.useVariant() && card.value.variant != null)
        {
            return card.value.variant;
        }
        
        return card.value.rank;
    }
}
