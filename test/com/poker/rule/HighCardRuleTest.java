package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class HighCardRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new HighCardRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getHighCard())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(1, (int)rule.compareTo(new Hand(getHighCard()), new Hand(getHighCard(Value.NINE))));
        assertEquals(0, (int)rule.compareTo(new Hand(getHighCard()), new Hand(getHighCard())));
        assertEquals(-1, (int)rule.compareTo(new Hand(getHighCard()), new Hand(getHighCard(Value.KING))));
    }
}
