package lc2259RemoveDigitFromNumberForMaxResult;

import java.math.BigInteger;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(removeDigit("1231", '1'));
        System.out.println(removeDigit("551", '5'));
    }

    private static String removeDigit(String number, char digit) {
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String temp = number.substring(0, i) + number.substring(i + 1);
                BigInteger tempRes = new BigInteger(temp);
                if ((tempRes.compareTo(result)) == 1 ) {
                    result = tempRes;
                }
            }
        }
        return String.valueOf(result);
    }
}
