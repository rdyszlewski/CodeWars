package com.parabbits.snail;

public class Snail {

    private static int[] RIGHT = {0,1};
    private static int[] DOWN = {1, 0};
    private static int[] LEFT = {0,-1};
    private static int[] UP = {-1, 0};

    private static int X = 0;
    private static int Y = 1;

    private static int[][] ORDERED_DIRECTIONS = {RIGHT, DOWN, LEFT, UP};

    public static int[] snail(int[][] array) {

        if (array.length == 0 || array[0].length == 0){
            return new int[0];
        }

        int ySize = array.length;
        int xSize = array[0].length;
        int elementsSize = ySize * xSize;

        boolean[][] visitedFields = new boolean[ySize][xSize];
        int visitedCounter = 0;
        int[] currentPosition = {0,0};
        int directionPosition = 0;
        int[] currentDirection = ORDERED_DIRECTIONS[directionPosition];

        int[] result = new int[elementsSize];
        while (visitedCounter < elementsSize){

            int element = array[currentPosition[X]][currentPosition[Y]];
            result[visitedCounter] = element;
            visitedFields[currentPosition[X]][currentPosition[Y]] = true;
            visitedCounter += 1;

            int[] nextPosition = getNextPosition(currentPosition, currentDirection);
            int xPosition = nextPosition[X];
            int yPosition = nextPosition[Y];
            if (xPosition >= xSize || xPosition < 0 || yPosition >= ySize || yPosition < 0 || visitedFields[xPosition][yPosition]){
                directionPosition = directionPosition != ORDERED_DIRECTIONS.length - 1 ? directionPosition + 1: 0;
                currentDirection = ORDERED_DIRECTIONS[directionPosition];
                nextPosition = getNextPosition(currentPosition, currentDirection);
            }
            currentPosition = nextPosition;
        }

        return  result;
    }

    private static int[] getNextPosition(int[] currentPosition, int[] currentDirection) {
        int[] nextPosition = {currentPosition[X] + currentDirection[X], currentPosition[Y] + currentDirection[Y]};
        return nextPosition;
    }

}