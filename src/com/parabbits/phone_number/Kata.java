package com.parabbits.phone_number;

/*
Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
Example:

Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"

The returned format must be correct in order to complete this challenge.
Don't forget the space after the closing parentheses!

 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        assert(numbers.length == 10);
        String numberText = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(""));
        return String.format("(%s) %s-%s",
                numberText.substring(0, 3),
                numberText.substring(3,6),
                numberText.substring(6, 10));
    }

    public static String createPhoneNumber2(int [] numbers){
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }
}
