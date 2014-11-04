package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class OnePairRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new OnePairRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getOnePair())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(9, (int)rule.compareTo(new Hand(getOnePair()), new Hand(getOnePair(Value.TWO, Value.FIVE))));
        assertEquals(0, (int)rule.compareTo(new Hand(getOnePair()), new Hand(getOnePair())));
        assertEquals(-3, (int)rule.compareTo(new Hand(getOnePair()), new Hand(getOnePair(Value.ACE, Value.TEN))));
    }
}
