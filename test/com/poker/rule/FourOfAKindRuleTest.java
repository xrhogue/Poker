package com.poker.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.poker.BaseTest;
import com.poker.model.Hand;
import com.poker.model.Card.Value;

public class FourOfAKindRuleTest extends BaseTest
{
    private Rule   rule;
    
    @Before
    public void setUp() throws Exception
    {
        rule = new FourOfAKindRule();
    }

    @Test
    public void testMatches()
    {
        assertTrue(rule.matches(new Hand(getFourOfAKind())));
    }

    @Test
    public void testCompareTo()
    {
        assertEquals(9, (int)rule.compareTo(new Hand(getFourOfAKind()), new Hand(getFourOfAKind(Value.TWO, Value.FIVE))));
        assertEquals(0, (int)rule.compareTo(new Hand(getFourOfAKind()), new Hand(getFourOfAKind())));
        assertEquals(-2, (int)rule.compareTo(new Hand(getFourOfAKind()), new Hand(getFourOfAKind(Value.KING, Value.TEN))));
    }
}
