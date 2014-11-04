package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class TwoPairRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new TwoPairRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getTwoPair())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(6, (int)rule.compareTo(new Hand(getTwoPair()), new Hand(getTwoPair(Value.TWO, Value.FIVE, Value.SIX))));
        assertEquals(0, (int)rule.compareTo(new Hand(getTwoPair()), new Hand(getTwoPair())));
        assertEquals(-2, (int)rule.compareTo(new Hand(getTwoPair()), new Hand(getTwoPair(Value.KING, Value.TEN, Value.QUEEN))));
    }
}
