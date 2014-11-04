package com.poker.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class HandTest extends BaseTest
{
    private Hand    hand;
    
    @Before
    public void setUp() throws Exception
    {
        hand = new Hand();
    }

    @Test
    public void testHand()
    {
        assertNotNull(hand);
    }

    @Test
    public void testHandListOfCard()
    {
        List<Card>  cards = new ArrayList<Card>();
        
        cards.add(new Card(Suit.SPADE, Value.ACE));
        
        assertNotNull(new Hand(cards));
    }

    @Test
    public void testAddCard()
    {
        Card    card = new Card(Suit.SPADE, Value.ACE);
        
        hand.addCard(card);
        
        List<Card>  cards = hand.getCards();
        
        assertNotNull(cards);
        assertEquals(1, cards.size());
        assertEquals(card, cards.get(0));
    }

    @Test
    public void testGetCards()
    {
        List<Card>  cards = hand.getCards();
        
        assertNotNull(cards);
        assertEquals(0, cards.size());
    }

    @Test
    public void testGetType()
    {
        assertEquals(Type.STRAIGHT_FLUSH, new Hand(getStraightFlush()).getType());
        assertEquals(Type.FOUR_OF_A_KIND, new Hand(getFourOfAKind()).getType());
        assertEquals(Type.FULL_HOUSE, new Hand(getFullHouse()).getType());
        assertEquals(Type.FLUSH, new Hand(getFlush()).getType());
        assertEquals(Type.STRAIGHT, new Hand(getStraight()).getType());
        assertEquals(Type.THREE_OF_A_KIND, new Hand(getThreeOfAKind()).getType());
        assertEquals(Type.TWO_PAIR, new Hand(getTwoPair()).getType());
        assertEquals(Type.ONE_PAIR, new Hand(getOnePair()).getType());
        assertEquals(Type.HIGH_CARD, new Hand(getHighCard()).getType());
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(2, new Hand(getStraight()).compareTo(new Hand(getTwoPair())));
        assertEquals(0, new Hand(getStraight()).compareTo(new Hand(getStraight())));
        assertEquals(-4, new Hand(getStraight()).compareTo(new Hand(getStraightFlush())));
    }
}
