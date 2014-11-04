package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Suit;
import com.poker.model.Card.Value;

public class FlushRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new FlushRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getFlush())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(1, (int)rule.compareTo(new Hand(getFlush()), new Hand(getFlush(Suit.DIAMOND, Value.FIVE))));
        assertEquals(0, (int)rule.compareTo(new Hand(getFlush()), new Hand(getFlush())));
        assertEquals(-1, (int)rule.compareTo(new Hand(getFlush()), new Hand(getFlush(Suit.DIAMOND, Value.TEN))));
    }
}
