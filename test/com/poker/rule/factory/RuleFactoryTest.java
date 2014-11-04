package com.poker.rule.factory;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.poker.annotation.HandRule.Type;
import com.poker.rule.HighCardRule;
import com.poker.rule.Rule;
import com.poker.rule.StraightFlushRule;

public class RuleFactoryTest
{
    @Test
    public void testGetRules()
    {
        List<Rule>  rules = RuleFactory.getRules();
        
        assertNotNull(rules);
        assertEquals(9, rules.size());
    }

    @Test
    public void testGetRule()
    {
        assertEquals(StraightFlushRule.class, RuleFactory.getRule(Type.STRAIGHT_FLUSH).getClass());
    }

    @Test
    public void testGetDefaultRule()
    {
        assertEquals(HighCardRule.class, RuleFactory.getDefaultRule().getClass());
    }
}
