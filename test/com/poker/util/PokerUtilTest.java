package com.poker.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.poker.BaseTest;
import com.poker.annotation.HandRule.Type;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class PokerUtilTest extends BaseTest
{
    @Test
    public void testCompareSameType()
    {
        assertEquals(1, PokerUtil.compareSameType(new Hand(getStraight()), new Hand(getStraight(Value.THREE))));
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
}
