package com.poker.service;

import com.poker.model.Hand;

public class PokerService
{
    public PokerService()
    {        
    }
    
    public int compare(final Hand hand1, final Hand hand2)
    {
        return hand1.compareTo(hand2);
    }
}
