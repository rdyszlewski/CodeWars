package com.parabbits.range_extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
A format for expressing an ordered list of integers is to use a comma separated list of either

    individual integers
    or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"

Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

Example:

Solution.rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
# returns "-6,-3-1,3-5,7-11,14,15,17-20"
 */
public class Solution {

    public static String rangeExtraction(int[] arr) {
        StringBuilder builder = new StringBuilder();
        Integer previousNumber = null;
        List<Integer> numberList = new ArrayList<>();
        for(int number: arr) {
            if (previousNumber != null) {
                if (number != previousNumber + 1) {
                    addNumbers(numberList, builder, true);
                }
            }
            numberList.add(number);
            previousNumber = number;
        }
        addNumbers(numberList, builder, false);
        return builder.toString();
    }

    private static void addNumbers(List<Integer> numberList, StringBuilder builder, boolean comma){
        if (numberList.size() >= 3) {
            builder.append(numberList.get(0)).append("-").append(numberList.get(numberList.size() - 1));
        } else {
            builder.append(numberList.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
        if(comma){
            builder.append(",");
        }
        numberList.clear();
    }
}
