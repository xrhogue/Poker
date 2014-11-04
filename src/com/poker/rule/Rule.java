package com.poker.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.poker.annotation.HandRule;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Card;
import com.poker.model.Hand;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public abstract class Rule
{
    abstract public Boolean matches(final Hand hand);
    abstract public Integer compareTo(final Hand hand1, final Hand hand2);
    
    public Integer getRank()
    {
        return this.getClass().getAnnotation(HandRule.class).rank();
    }
        
    public Type getType()
    {
        return this.getClass().getAnnotation(HandRule.class).type();
    }
    
    protected int compareHighToLow(final Hand hand1, final Hand hand2)
    {
        for (int index = 0; index < hand1.getCards().size(); index++)
        {
            if (hand1.getCards().get(index).getValue().getValue() > hand2.getCards().get(index).getValue().getValue())
            {
                return 1;
            }
            
            if (hand1.getCards().get(index).getValue().getValue() < hand2.getCards().get(index).getValue().getValue())
            {
                return -1;
            }
        }
        
        return 0;
    }
    
    protected int compareMaxCountValue(final Hand hand1, final Hand hand2)
    {
        return getMaxCountValue(hand1).compareTo(getMaxCountValue(hand1));
    }
    
    protected int compareCountValues(final Hand hand1, final Hand hand2)
    {
        List<ValueCount> valueCounts1 = getValueCounts(hand1);
        List<ValueCount> valueCounts2 = getValueCounts(hand2);
        
        for (int index = 0; index < valueCounts1.size(); index++)
        {
            int compare = valueCounts1.get(index).getValue().compareTo(valueCounts2.get(index).getValue());
            
            if (compare != 0)
            {
                return compare;
            }
        }
        
        return 0;
    }
   
    protected Boolean isStraightFlush(final Hand hand)
    {
        return isStraight(hand) && isSingleSuit(hand);
    }
    
    protected Boolean isFourOfAKind(final Hand hand)
    {
        return getMaxCount(hand) >= 4;
    }
    
    protected Boolean isFullHouse(final Hand hand)
    {
        List<ValueCount>    valueCounts = getValueCounts(hand);
        
        return valueCounts.size() == 2 && valueCounts.get(0).getCount() == 3 && valueCounts.get(1).getCount() == 2;
    }
    
    protected Boolean isFlush(final Hand hand)
    {
        return isSingleSuit(hand);
    }
    
    protected Boolean isStraight(final Hand hand)
    {
        List<Card>  cards = hand.getCards();
        Boolean     isStraight = true;
        
        for (int index = 0; index < cards.size() - 1; index++)
        {
            if (cards.get(index).getValue().getValue() != cards.get(index + 1).getValue().getValue() + 1)
            {
                isStraight = false;
            }
        }

        // special case
        if (!isStraight)
        {
            if (hand.hasAce())
            {
                cards = new ArrayList<Card>();
                
                for (int index = 1; index < hand.getCards().size(); index++)
                {
                    cards.add(hand.getCards().get(index));
                }
                
                cards.add(hand.getCards().get(0));
                
                for (int index = 0; index < cards.size() - 1; index++)
                {
                    if (cards.get(index).getValue().getValue() != cards.get(index + 1).getValue().getValue() + 1)
                    {
                        return false;
                    }
                }
            }
            else
            {
                return isStraight;
            }
        }
        
        return true;
    }
    
    protected Boolean isThreeOfAKind(final Hand hand)
    {
        return getMaxCount(hand) >= 3;
    }
    
    protected Boolean isTwoPair(final Hand hand)
    {
        return getPairCount(hand) == 2;
    }
    
    protected Boolean isOnePair(final Hand hand)
    {
        return getPairCount(hand) == 1;
    }
    
    protected Boolean isSingleSuit(final Hand hand)
    {
        Suit    suit = hand.getCards().get(0).getSuit();
        
        for (Card card : hand.getCards())
        {
            if (suit != card.getSuit())
            {
                return false;
            }
        }
        
        return true;
    }
    
    protected Integer getPairCount(final Hand hand)
    {
        Integer pairCount = 0;
        
        for (ValueCount valueCount : getValueCounts(hand))
        {
            if (valueCount.getCount() == 2)
            {
                pairCount++;
            }
        }
        
        return pairCount;
    }
    
    protected Integer getMaxCount(final Hand hand)
    {
        Integer maxCount = 0;
        
        for (ValueCount valueCount : getValueCounts(hand))
        {
            maxCount = Math.max(valueCount.getCount(),  maxCount);
        }
        
        return maxCount;
    }
    
    protected Value getMaxCountValue(final Hand hand)
    {
        return getValueCounts(hand).get(0).getValue();
    }
   
    protected List<ValueCount> getValueCounts(final Hand hand)
    {
        Map<Value, Integer> valueCountMap = new HashMap<Value, Integer>();
        List<ValueCount>    valueCounts = new ArrayList<ValueCount>();
        
        for (Card card : hand.getCards())
        {
            if (!valueCountMap.containsKey(card.getValue()))
            {
                valueCountMap.put(card.getValue(), new Integer(0));
            }
            
            valueCountMap.put(card.getValue(), valueCountMap.get(card.getValue()) + 1);
        }
        
        for (Entry<Value, Integer> entry : valueCountMap.entrySet())
        {
            valueCounts.add(new ValueCount(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(valueCounts);
        Collections.reverse(valueCounts);
        
        return valueCounts;
    }
    
    protected class ValueCount implements Comparable<ValueCount>
    {
        private Value   value;
        private Integer count;
        
        public ValueCount(final Value value, final Integer count)
        {
            this.value = value;
            this.count = count;
        }

        public Value getValue()
        {
            return value;
        }

        public Integer getCount()
        {
            return count;
        }

        @Override
        public boolean equals(Object obj)
        {
            return this.value.equals(((ValueCount)obj).value);
        }

        @Override
        public int compareTo(ValueCount valueCount)
        {
            int compare = this.count.compareTo(valueCount.count);
            
            if (compare == 0)
            {
                return this.value.compareTo(valueCount.value);
            }
            
            return compare;
        }
    }
}
