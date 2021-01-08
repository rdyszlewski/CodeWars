package com.parabbits.large_factorials;

/*
In mathematics, the factorial of integer n is written as n!. It is equal to the product of n and every integer preceding it. For example: 5! = 1 x 2 x 3 x 4 x 5 = 120

Your mission is simple: write a function that takes an integer n and returns the value of n!.

You are guaranteed an integer argument. For any values outside the non-negative range, return null, nil or None (return an empty string "" in C and C++). For non-negative numbers a full length number is expected for example, return 25! = "15511210043330985984000000" as a string.

For more on factorials, see http://en.wikipedia.org/wiki/Factorial

NOTES:

    The use of BigInteger or BigNumber functions has been disabled, this requires a complex solution

    I have removed the use of require in the javascript language.


 */
public class Kata {
    public static String Factorial(int n) {
        BigInt value = new BigInt(String.valueOf(1));
        for(int i =2; i <= n; i++){
            value.multiply(i);
        }
        return value.getValue();
    }

    private static class BigInt{
        private String value = "0";

        public BigInt(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        public void multiply(int multiplierValue){
            String multiplier = String.valueOf(multiplierValue);
            int resultSize = multiplier.length() + value.length();
            int[][] tempResult = getMultiplyResult(multiplier, resultSize);
            int[] addResult = addMultiplyResult(tempResult);
            value = getStringFromResult(resultSize, addResult);
        }

        private String getStringFromResult(int resultSize, int[] addResult) {
            char[] result = new char[resultSize];
            for(int i = 0; i< addResult.length; i++){
                result[i] = Character.forDigit(addResult[i], 10);
            }
            String resultValue =  String.valueOf(result);
            return resultValue.replaceFirst("^0*","");
        }

        private int[][] getMultiplyResult(String multiplier, int resultSize) {
            int[][] tempResult = new int[multiplier.length()][resultSize];
            int startOffset = 0;
            int valueOffset = resultSize - value.length();
            for(int i = multiplier.length() - 1; i>=0; i--){
                int currentPosition = tempResult[0].length -1 - startOffset;
                int temp = 0;
                int a = Character.getNumericValue(multiplier.charAt(i));
                for(int j=tempResult[0].length -1; j>=startOffset; j--){
                    int index = j - valueOffset;
                    int b = j >= valueOffset? Character.getNumericValue(value.charAt(index)): 0;
                    int multiplyResult = a * b + temp;
                    temp = 0;
                    if(multiplyResult >= 10){
                        temp = multiplyResult / 10;
                        multiplyResult = multiplyResult % 10;
                    }
                    tempResult[i][currentPosition] = multiplyResult;
                    currentPosition--;
                }
                startOffset++;
            }
            return tempResult;
        }

        private int[] addMultiplyResult(int[][] tempResult){
            int resultSize = tempResult[0].length;
            int [] addResult = new int[resultSize];
            for(int i=tempResult.length - 1; i>=0; i--){
                int temp = 0;
                for(int j=tempResult[0].length - 1; j>=0; j--){
                    addResult[j] += tempResult[i][j] + temp;
                    temp = 0;
                    if(addResult[j] >= 10){
                        temp = addResult[j]/10;
                        addResult[j] %= 10;
                    }
                }
            }
            return addResult;
        }
    }
}
