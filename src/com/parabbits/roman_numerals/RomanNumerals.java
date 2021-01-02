package com.parabbits.roman_numerals;

import java.util.*;

/*
Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
Examples

RomanNumerals.toRoman(1000) // should return 'M'
RomanNumerals.fromRoman("M") // should return 1000

Help

| Symbol | Value |
|----------------|
| I      |  1    |
| V      |  5    |
| X      |  10   |
| L      |  50   |
| C      |  100  |
| D      |  500  |
| M      |  1000 |
 */
public class RomanNumerals {

    final static String[] symbols =
                    {"I","IV", "V", "IX",
                    "X","XL", "L" ,"XC",
                    "C","CD", "D", "CM", "M"};

    final static Map<Character, Integer> valuesMap = new HashMap<>();

    final static Map<Integer, Integer> numberIndexMap = new HashMap<>();
    static{
        numberIndexMap.put(9, 3);
        numberIndexMap.put(1, 0);
        numberIndexMap.put(4, 1);
        numberIndexMap.put(5, 2);
    }

    static {
        valuesMap.put('I', 1);
        valuesMap.put('V', 5);
        valuesMap.put('X', 10);
        valuesMap.put('L', 50);
        valuesMap.put('C', 100);
        valuesMap.put('D', 500);
        valuesMap.put('M', 1000);
    }

    public static String toRoman(int n) {
        final List<Integer> digits = getDigits(n);
        final StringBuilder numberBuilder = new StringBuilder();
        for(int i = digits.size() - 1; i >= 0; i--){
            int value = digits.get(i);
            int offset = i * 4;
            if(numberIndexMap.containsKey(value)){
                numberBuilder.append(symbols[offset + numberIndexMap.get(value)]);
            } else {
                if(value >= 5){
                    numberBuilder.append(symbols[offset + numberIndexMap.get(5)]);
                    value -= 5;
                }
                numberBuilder.append(
                        String.valueOf(symbols[offset + numberIndexMap.get(1)]).repeat(value)
                );
            }
        }
        return numberBuilder.toString();
    }

    private static List<Integer> getDigits(int n){
        List<Integer> numbers = new ArrayList<>();
        int number = n;
        while(number != 0){
            int value = number % 10;
            numbers.add(value);
            number = number / 10;
        }
        return numbers;
    }

    public static int fromRoman(String romanNumeral) {
        int number = 0;
        final StringBuilder numeralBuilder = new StringBuilder();
        int lastValue = 0;
        char[] romanArray = romanNumeral.toCharArray();
        for(int i = romanArray.length - 1; i >= 0; i--){
            char character = romanArray[i];
            int value = valuesMap.get(character);
            if(value < lastValue){
                number -= value;
            } else {
                number += value;
            }
            lastValue = value;
        }
        return number;
    }



//    private static final Map<Integer, String> CONVERSIONS;
//    static {
//        TreeMap<Integer, String> map = new TreeMap<>();
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");
//        CONVERSIONS = Collections.unmodifiableMap(map.descendingMap());
//    }
//
//    public static String toRoman(int n) {
//        StringBuilder result = new StringBuilder();
//        for (Map.Entry<Integer, String> entry : CONVERSIONS.entrySet()) {
//            while (n >= entry.getKey()) {
//                result.append(entry.getValue());
//                n -= entry.getKey();
//            }
//        }
//        return result.toString();
//    }
//
//    public static int fromRoman(String romanNumeral) {
//        int result = 0;
//        for (Map.Entry<Integer, String> entry : CONVERSIONS.entrySet()) {
//            while (romanNumeral.startsWith(entry.getValue())) {
//                result += entry.getKey();
//                romanNumeral = romanNumeral.substring(entry.getValue().length());
//            }
//        }
//        return result;
//    }
}
