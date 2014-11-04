package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class StraightFlushRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new StraightFlushRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getStraightFlush())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(1, (int)rule.compareTo(new Hand(getStraightFlush()), new Hand(getStraightFlush(Value.FIVE, Suit.DIAMOND))));
        assertEquals(0, (int)rule.compareTo(new Hand(getStraightFlush()), new Hand(getStraightFlush())));
        assertEquals(-1, (int)rule.compareTo(new Hand(getStraightFlush()), new Hand(getStraightFlush(Value.TEN, Suit.DIAMOND))));
    }
}
