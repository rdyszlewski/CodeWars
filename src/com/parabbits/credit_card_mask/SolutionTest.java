package com.parabbits.credit_card_mask;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertEquals("############5616", Solution.maskify("4556364607935616"));
        assertEquals("#######5616",      Solution.maskify(     "64607935616"));
        assertEquals("1",                Solution.maskify(               "1"));
        assertEquals("",                 Solution.maskify(                ""));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    Solution.maskify("Skippy")                                  );
        assertEquals("####################################man!",  Solution.maskify("Nananananananananananananananana Batman!"));
    }
}