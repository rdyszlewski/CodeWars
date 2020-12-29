package com.parabbits.find_parity_outliner;

import java.util.stream.Stream;

/*

You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
Examples

[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)


 */

public class FindOutlier {
    static int find(int[] integers) {
        Integer lastOdd = null;
        Integer lastEven = null;
        int oddCounter = 0;
        int evenCounter = 0;
        for (int i = 0; i < integers.length; i++) {
            int value = integers[i];
            boolean isEvent = value % 2 == 0;
            if (isEvent) {
                evenCounter++;
                lastEven = value;
                if (evenCounter >= 2 && lastOdd != null) {
                    return lastOdd;
                }
            } else {
                oddCounter++;
                lastOdd = value;
                if (oddCounter >= 2 && lastEven != null) {
                    return lastEven;
                }
            }
        }
        if(oddCounter > evenCounter && lastEven != null){
            return lastEven;
        }
        if(evenCounter > oddCounter && lastOdd != null){
            return lastOdd;
        }
        return 0;
    }

    // TODO: dodać rozwiązanie z streamem. Najpierw sprawdzamy, czy więcej jest parzystych czy nie
}
