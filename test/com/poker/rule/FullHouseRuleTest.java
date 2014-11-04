package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class FullHouseRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new FullHouseRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getFullHouse())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(9, (int)rule.compareTo(new Hand(getFullHouse()), new Hand(getFullHouse(Value.TWO, Value.FIVE))));
        assertEquals(0, (int)rule.compareTo(new Hand(getFullHouse()), new Hand(getFullHouse())));
        assertEquals(-2, (int)rule.compareTo(new Hand(getFullHouse()), new Hand(getFullHouse(Value.KING, Value.TEN))));
    }
}
