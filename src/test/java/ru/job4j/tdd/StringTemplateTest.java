package ru.job4j.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringTemplateTest {

    @Test
    public void produce() {
        StringTemplate st = new StringTemplate();
        String template = "Me name is ${name}";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Pavel");
        var act = st.produce(template, keys);
        assertThat(act, is("Me name is Pavel"));
    }

    @Test
    public void whenProduceWithThreeParameters() {
        StringTemplate st = new StringTemplate();
        String template = "Me name is ${name}, I am ${age} years old and live in ${city}";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Pavel");
        keys.put("age", "23");
        keys.put("city", "Saint-P.");
        var act = st.produce(template, keys);
        assertThat(act, is("Me name is Pavel, I am 23 years old and live in Saint-P."));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTooManyParameterInMap() {
        StringTemplate st = new StringTemplate();
        String template = "Me name is ${name}, I am ${age} years old.}";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Pavel");
        keys.put("age", "23");
        keys.put("city", "Saint-P.");
        var act = st.produce(template, keys);
        assertThat(act, is("Me name is Pavel, I am 23 years old and live in Saint-P."));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTooManyParameterInTemplate() {
        StringTemplate st = new StringTemplate();
        String template = "Me name is ${name}, I am ${age} years old and live in ${city}";
        Map<String, String> keys = new HashMap<>();
        keys.put("name", "Pavel");
        keys.put("age", "23");
        var act = st.produce(template, keys);
    }

}