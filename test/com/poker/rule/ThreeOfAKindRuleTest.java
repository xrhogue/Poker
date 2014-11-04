package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class ThreeOfAKindRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new ThreeOfAKindRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getThreeOfAKind())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(11, (int)rule.compareTo(new Hand(getThreeOfAKind()), new Hand(getThreeOfAKind(Value.TWO, Value.FIVE, Value.JACK))));
        assertEquals(0, (int)rule.compareTo(new Hand(getThreeOfAKind()), new Hand(getThreeOfAKind())));
        assertEquals(-1, (int)rule.compareTo(new Hand(getThreeOfAKind()), new Hand(getThreeOfAKind(Value.ACE, Value.TEN, Value.SIX))));
    }
}
