package lc2864MaxOddBinaryNo;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        String num = "00111";

        System.out.println(maximumOddBinaryNumber(num));
    }

    private static String maximumOddBinaryNumber(String s) {
        char[] str = s.toCharArray();
        int last0 = -1;
        int last1 = -1;

        for (int i = 0; i < str.length; i++) {
            int curr = str[i];
            if (curr == 49) {
                if ((last0 > -1) && (str[last0] == 48)) {
                    str[i] = 48;
                    str[last0] = 49;
                    last1 = last0;
                    last0 = last0 + 1;
                } else {
                    last1 = i;
                }
            } else {
                if (last0 == -1) {
                    last0 = i;
                }
            }
        }

        if((last1 != -1) && (last1 != (str.length-1))){
            str[last1] = 48;
            str[str.length-1] = 49;
        }
        StringBuilder result = new StringBuilder();
        for (char val : str) {
            result.append(val);
        }

        return result.toString();
    }
}
