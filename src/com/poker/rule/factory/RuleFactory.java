package com.poker.rule.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.poker.annotation.HandRule;
import com.poker.rule.Rule;

public class RuleFactory
{
    public static List<Rule> getRules()
    {
        Reflections     relections = new Reflections("com.poker.rule");
        Set<Class<?>>   ruleClasses = relections.getTypesAnnotatedWith(HandRule.class);
        List<Rule>      rules = new ArrayList<Rule>();
        
        for (int index = 0; index < ruleClasses.size(); index++)
        {
            rules.add(null);
        }
        
        for (Class<?> ruleClass : ruleClasses)
        {
            try
            {
                Rule    rule = (Rule)ruleClass.newInstance();
                
                rules.set(rule.getRank(), rule);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        Collections.reverse(rules);
        
        return rules;
    }
    
    public static Rule getRule(final HandRule.Type type)
    {
        for (Rule rule : getRules())
        {
            if (rule.getType().equals(type))
            {
                return rule;
            }
        }
        
        return getDefaultRule();
    }
    
    public static Rule getDefaultRule()
    {
        List<Rule>  rules = getRules();
        
        return rules.get(rules.size() - 1);
    }
}
