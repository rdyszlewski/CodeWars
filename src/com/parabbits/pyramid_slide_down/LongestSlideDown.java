package com.parabbits.pyramid_slide_down;
public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        for (int i = pyramid.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                pyramid[i - 1][j] += Math.max(pyramid[i][j], pyramid[i][j + 1]);
            }
        }
        return pyramid[0][0];
    }
}