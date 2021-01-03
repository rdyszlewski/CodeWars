package com.parabbits.middle_permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 You are given a string s. Every letter in s appears once.

Consider all strings formed by rearranging the letters in s. After ordering these strings in dictionary order, return the middle term. (If the sequence has a even length n, define its middle term to be the (n/2)th term.)
Example

For s = "abc", the result should be "bac".

The permutations in order are: "abc", "acb", "bac", "bca", "cab", "cba" So, The middle term is "bac".
Input/Output

    [input] string s

    unique letters (2 <= length <= 26)

    [output] a string

    middle permutation.

 */
public class MiddlePermutation {
    public static String findMidPerm(String string) {
        List<Character> results = new ArrayList<>();
        List<Character> text = string.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        findMiddlePermutation(text, results);
        StringBuilder builder = new StringBuilder();
        for(Character ch: results){
            builder.append(ch);
        }
        return builder.toString();
    }

    private static void findMiddlePermutation(List<Character> text, List<Character> results){
        if(text.size() == 0){
            return;
        }
        if(text.size() % 2==0){
            int index = text.size() / 2 -1;
            char middle = text.get(index);
            text.remove(index);
            Collections.reverse(text);
            results.add(middle);
            results.addAll(text);
        } else {
            int index = text.size() / 2;
            char middle = text.get(index);
            text.remove(index);
            results.add(middle);
            findMiddlePermutation(text, results);
        }
    }

//    public static String findMidPerm(String string) {
//        List<String> permutations = new ArrayList<>();
//        permute(string.toCharArray(), 0, permutations);
//        Collections.sort(permutations);
//        int index = permutations.size() % 2 == 0? permutations.size() / 2 - 1: permutations.size() /2;
//        return permutations.get(index);
//    }
//
//    private static void permute(char[] arr, int k, List<String> result){
//        for(int i = k; i < arr.length; i++){
//            swap(arr, i, k);
//            permute(arr, k+1, result);
//            swap(arr, k, i);
//        }
//        if (k == arr.length -1){
//            result.add(new String(arr));
//        }
//    }
//
//    public static  void swap (char[] a, int i, int j) {
//        char t = a[i];
//        a[i] = a[j];
//        a[j] = t;
//    }

// II

//    public static String findMidPerm(String strng) {
//
//        char[] arrStr = strng.toCharArray();
//        Arrays.sort(arrStr);
//        StringBuilder s = new StringBuilder(new String(arrStr)).reverse();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(s.substring( s.length()/2, (s.length()+3)/2 ));
//        sb.append(s.substring( 0,             s.length()/2    ));
//        sb.append(s.substring( (s.length()+3)/2 ));
//
//        return sb.toString();
//    }


    // III

//    public static String findMidPerm(String strng) {
//        String sorted = strng.chars()
//                .mapToObj(c -> String.valueOf((char) c))
//                .sorted(Comparator.reverseOrder())
//                .reduce("", (a, b) -> a + b);
//        String prefix = sorted.substring(sorted.length() / 2, sorted.length() / 2 + sorted.length() % 2 + 1);
//        return prefix + sorted.replaceAll(prefix, "");
//    }
}
