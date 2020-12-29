package com.parabbits.credit_card_mask;

import java.util.Collections;

public class Solution {

    public static String maskify(String str) {
        final int visibleChars = 4;
        if(str.length() <= visibleChars){
            return str;
        }
        final int maskLength = str.length()-visibleChars;
        String maskResult = String.join("", Collections.nCopies(maskLength, "#"));
        maskResult += str.substring(maskLength);
        return maskResult;
    }
}
