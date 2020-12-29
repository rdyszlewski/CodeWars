package com.parabbits.likes;

class Solution {



    public static String whoLikesIt(String... names) {

        final String ONE_LIKE = "%s likes this";
        final String TWO_LIKES = "%s and %s like this";
        final String THREE_LIKES = "%s, %s and %s like this";
        final String MORE_LIKES = "%s, %s and %d others like this";

        if (names.length == 0){
            return "no one likes this";
        }
        switch (names.length){
            case 1:
                return String.format(ONE_LIKE, names);
            case 2:
                return String.format(TWO_LIKES, names);
            case 3:
                return String.format(THREE_LIKES, names);
            default:
                return String.format(MORE_LIKES, names[0], names[1], names.length - 2);
        }
    }

}
