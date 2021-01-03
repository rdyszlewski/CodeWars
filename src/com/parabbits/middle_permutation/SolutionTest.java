package com.parabbits.middle_permutation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void basicTests() {
        MiddlePermutation.findMidPerm("0");
        MiddlePermutation.findMidPerm("01");
        MiddlePermutation.findMidPerm("012");
        MiddlePermutation.findMidPerm("0123");
        MiddlePermutation.findMidPerm("01234");
        MiddlePermutation.findMidPerm("012345");
        MiddlePermutation.findMidPerm("0123456");
        MiddlePermutation.findMidPerm("01234567");
        MiddlePermutation.findMidPerm("012345678");
        MiddlePermutation.findMidPerm("0123456789");
        assertEquals("bac", MiddlePermutation.findMidPerm("abc"));
        assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
        assertEquals("cbxda", MiddlePermutation.findMidPerm("abcdx"));
        assertEquals("cxgdba", MiddlePermutation.findMidPerm("abcdxg"));
        assertEquals("dczxgba", MiddlePermutation.findMidPerm("abcdxgz"));
    }
}
