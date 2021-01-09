package com.parabbits.rail_dence_cipher;

import java.util.List;

/*
Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail. Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:

W       E       C       R       L       T       E
  E   R   D   S   O   E   E   F   E   A   O   C
    A       I       V       D       E       N

The encoded string would be:

WECRLTEERDSOEEFEAOCAIVDEN

Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.

Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.

Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests that include punctuation. Don't filter out punctuation as they are a part of the string.

 */
public class RailFenceCipher {
    static String encode(String s, int n) {

        int base = n + (n - 2);
        int startPosition = 0;
        int resultPosition = 0;
        char[] resultArray = new char[s.length()];
        for(int level=0; level<n; level++){
            int firstInterval = base - 2 * level;
            int secondInterval = base - firstInterval;
            firstInterval = firstInterval == 0? secondInterval: firstInterval;
            secondInterval = secondInterval == 0? firstInterval: secondInterval;
            int currentPosition = startPosition;
            boolean isFirstInterval = true;
            while(currentPosition < s.length() && resultPosition < s.length()){
                resultArray[resultPosition] = s.charAt(currentPosition);
                currentPosition += isFirstInterval ? firstInterval: secondInterval;
                isFirstInterval = !isFirstInterval;
                resultPosition++;
            }
            startPosition++;
        }
        return new String(resultArray);
    }

    static String decode(String s, int n) {
        int base = n + (n - 2);
        int startPosition = 0;
        int position=0;
        char[] resultArray = new char[s.length()];
        for(int level=0; level<n; level++){
            int currentPosition = startPosition;
            int firstInterval = base - 2 * level;
            int secondInterval = base - firstInterval;
            firstInterval = firstInterval == 0? secondInterval: firstInterval;
            secondInterval = secondInterval == 0? firstInterval: secondInterval;
            boolean isFirstInterval = true;
            while(currentPosition < s.length() && position < s.length()){
                resultArray[currentPosition] = s.charAt(position);
                position++;
                currentPosition += isFirstInterval ? firstInterval: secondInterval;
                isFirstInterval = !isFirstInterval;
            }
            startPosition++;
        }
        return new String(resultArray);
    }
}
