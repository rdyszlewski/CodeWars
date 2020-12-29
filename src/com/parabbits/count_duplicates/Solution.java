package com.parabbits.count_duplicates;

import org.w3c.dom.css.Counter;

import java.util.*;

public class Solution {

    /*
    Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice

     */
    public static int duplicateCount(String text) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char c : text.toLowerCase().toCharArray()){
            if(!counter.containsKey(c)){
               counter.put(c, 1);
            } else {
                counter.put(c, counter.get(c)+1);
            }
        }
        return (int) counter.entrySet().stream().filter(p->p.getValue()>1).count();
    }
}