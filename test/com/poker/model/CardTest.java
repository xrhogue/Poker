package com.poker.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class CardTest
{
    private Card    card;
    
    @Before
    public void setUp() throws Exception
    {
        card = new Card(Suit.SPADE, Value.QUEEN);
    }

    @Test
    public void testCard()
    {
        assertNotNull(card);
    }

    @Test
    public void testGetSuit()
    {
        assertEquals(Suit.SPADE, card.getSuit());
    }

    @Test
    public void testGetValue()
    {
        assertEquals(Value.QUEEN, card.getValue());
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(1, card.compareTo(new Card(Suit.HEART, Value.SEVEN)));
        assertEquals(0, card.compareTo(new Card(Suit.SPADE, Value.QUEEN)));
        assertEquals(-1, card.compareTo(new Card(Suit.DIAMOND, Value.KING)));   
    }
}
