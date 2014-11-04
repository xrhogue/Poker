package com.poker.service;

import com.poker.model.Hand;

/**
 * Poker Service functionality
 * @author rhogue
 *
 */
public class PokerService
{
    public PokerService()
    {        
    }
    
    /**
     * Compares two hands and returns the comparison results
     * @param hand1
     * @param hand2
     * @return the comparison results
     */
    public int compare(final Hand hand1, final Hand hand2)
    {
        int compare = hand1.compareTo(hand2);
        
        if (compare > 1)
        {
            return 1;
        }
        
        if (compare < -1)
        {
            return -1;
        }
        
        return compare;
    }
}
