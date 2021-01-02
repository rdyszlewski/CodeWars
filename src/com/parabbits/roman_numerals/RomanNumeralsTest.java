package com.parabbits.roman_numerals;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {
    @Test
    public void testToRoman() throws Exception {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(1990), is("MCMXC"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2089), is("MMLXXXIX"));
    }

    @Test
    public void testFromRoman() throws Exception {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
        assertThat("2 converts to 'II'", RomanNumerals.fromRoman("MCMXC"), is(1990));
    }
}
