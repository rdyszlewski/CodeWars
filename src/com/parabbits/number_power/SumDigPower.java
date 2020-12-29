package com.parabbits.number_power;

import java.util.ArrayList;
import java.util.List;

/*
The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.

In effect: 89 = 8^1 + 9^2

The next number in having this property is 135.

See this property again: 135 = 1^1 + 3^2 + 5^3

We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.

Let's see some cases:

sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]

sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]

If there are no numbers of this kind in the range [a, b] the function should output an empty list.

sum_dig_pow(90, 100) == []

Enjoy it!!

 */
public class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        for(long number = a; number < b; number++){
            List<Long> digits = getDigits(number);
            long sum = sumDigits(digits);
            if(sum == number){
                result.add(number);
            }
        }
        return result;
    }

    private static List<Long> getDigits(long number){
        List<Long> digits = new ArrayList<>();
        long value = number;
        while (value>0) {
            digits.add(0, value % 10);
            value = value / 10;
        }
        return digits;
    }

    private static long sumDigits(List<Long> digits){
        long sum = 0;
        for(int i = 0; i<digits.size(); i++){
            double digitValue = Math.pow(digits.get(i), i+1);
            sum += digitValue;
        }
        return sum;
    }


//    public static List<Long> sumDigPow(long a, long b) {
//        return LongStream.rangeClosed(a, b)
//                .filter(i -> isValid(i))
//                .boxed()
//                .collect(Collectors.toList());
//    }
//
//    private static boolean isValid(long x){
//        String value = Long.toString(x);
//        return IntStream.range(0, value.length())
//                .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i + 1))
//                .sum() == x;
//    }
}
