package com.parabbits.secret_string;

import java.util.*;

/*
There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the original string.

A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".

As a simplification, you may assume that no letter occurs more than once in the secret string.

You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain sufficient information to deduce the original string. In particular, this means that the secret string will never contain letters that do not occur in one of the triplets given to you.

 */
public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        Map<Character, Set<Character>> charactersMap = prepareCharactersMap(triplets);
        return recoverText(charactersMap);
    }

    private Map<Character, Set<Character>> prepareCharactersMap(char[][] triplets){
        Map<Character, Set<Character>> characterMap = new HashMap<>();
        for(char[] triplet : triplets){
            for(int i=2; i >= 0; i--){
                char character = triplet[i];
                if(!characterMap.containsKey(character)){
                    characterMap.put(character, new HashSet<>());
                }
                for(int j=0; j<i; j++){
                    characterMap.get(character).add(triplet[j]);
                }
            }
        }
        return characterMap;
    }

    private String recoverText(Map<Character, Set<Character>> charactersMap){
        int numLetters = charactersMap.size();
        char[] resultArray = new char[numLetters];
        for(int i=0; i<numLetters; i++){
            Optional<Character> optionalCharacter = charactersMap.entrySet().stream().filter(x->x.getValue().isEmpty()).map(Map.Entry::getKey).findFirst();
            assert optionalCharacter.isPresent();
            char character = optionalCharacter.get();
            charactersMap.forEach((key, value) -> value.remove(character));
            charactersMap.remove(character);
            resultArray[i] = character;
        }
        return String.valueOf(resultArray);
    }
}
