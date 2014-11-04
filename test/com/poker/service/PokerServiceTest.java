package com.poker.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Card;
import com.poker.model.Hand;

public class PokerServiceTest extends BaseTest
{
    public static final int HAND_ONE_BETTER = 1;
    public static final int HANDS_EVEN = 0;
    public static final int HAND_TWO_BETTER = -1;
    
    private PokerService    pokerService;
    
    @Before
    public void setUp() throws Exception
    {
        pokerService = new PokerService();
    }

    @Test
    public void testPokerService()
    {
        assertNotNull(pokerService);
    }

    @Test
    public void testCompareOnePairVSHighCard()
    {
        assertEquals(HAND_ONE_BETTER,
                     pokerService.compare(getHand(AceOfSpades, AceOfHearts, TenOfDiamonds, FiveOfHearts, TwoOfClubs),
                                          getHand(KingOfHearts, QueenOfHearts, JackOfSpades, EightOfDiamonds, ThreeOfClubs)));
    }

    @Test
    public void testCompareTwoPairVSTwoPair()
    {
        assertEquals(HAND_ONE_BETTER,
                     pokerService.compare(getHand(AceOfSpades, AceOfHearts, TenOfDiamonds, TenOfHearts, TwoOfClubs),
                                          getHand(KingOfHearts, ThreeOfHearts, EightOfSpades, EightOfDiamonds, ThreeOfClubs)));
        assertEquals(HANDS_EVEN,
                     pokerService.compare(getHand(AceOfSpades, AceOfHearts, TenOfDiamonds, TenOfHearts, TwoOfClubs),
                                          getHand(AceOfClubs, AceOfDiamonds, TenOfSpades, TenOfClubs, TwoOfHearts)));
    }

    @Test
    public void testCompareFullHouseVSThreeOfAKind()
    {
        assertEquals(HAND_ONE_BETTER,
                     pokerService.compare(getHand(AceOfSpades, AceOfHearts, TenOfDiamonds, TenOfHearts, TenOfClubs),
                                          getHand(KingOfHearts, KingOfSpades, KingOfDiamonds, EightOfDiamonds, ThreeOfClubs)));
    }

    @Test
    public void testCompareFlushVSStraightFlush()
    {
        assertEquals(HAND_TWO_BETTER,
                     pokerService.compare(getHand(AceOfSpades, TwoOfSpades, TenOfSpades, SixOfSpades, JackOfSpades),
                                          getHand(KingOfHearts, QueenOfHearts, JackOfHearts, TenOfHearts, NineOfHearts)));
    }

    @Test
    public void testCompareAceLowStraight()
    {
        assertEquals(HAND_ONE_BETTER,
                     pokerService.compare(getHand(AceOfSpades, TwoOfHearts, ThreeOfDiamonds, FourOfHearts, FiveOfClubs),
                                          getHand(KingOfHearts, QueenOfHearts, KingOfSpades, EightOfDiamonds, ThreeOfClubs)));

        assertEquals(HAND_TWO_BETTER,
                     pokerService.compare(getHand(AceOfSpades, TwoOfHearts, ThreeOfDiamonds, FourOfHearts, FiveOfClubs),
                                          getHand(TwoOfSpades, ThreeOfHearts, FourOfSpades, FiveOfDiamonds, SixOfClubs)));
        
        assertEquals(HAND_TWO_BETTER,
                     pokerService.compare(getHand(AceOfSpades, TwoOfHearts, ThreeOfDiamonds, FourOfHearts, FiveOfClubs),
                                          getHand(KingOfHearts, QueenOfHearts, JackOfSpades, TenOfDiamonds, AceOfClubs)));

    }

    private Hand getHand(Card ... cards)
    {
        Hand    hand = new Hand();
        
        for (Card card : cards)
        {
            hand.addCard(card);            
        }
        
        return hand;
    }
}
