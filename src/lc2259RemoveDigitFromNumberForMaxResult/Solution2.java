package lc2259RemoveDigitFromNumberForMaxResult;


//TODO fix it. It doesn't work in all cases.
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(removeDigit("1231", '1'));
        System.out.println(removeDigit("551", '5'));
    }

    private static String removeDigit(String number, char digit) {
        int n = number.length();
        int lastInd = -1;
        int ind = -1;
        for (int x = 1; x < n; x++) {
            char prev = number.charAt(x - 1);
            char cur = number.charAt(x);
            if (prev == digit) {
                lastInd = x - 1;
                if (cur > prev) {
                    ind = x - 1;
                    break; // Exit the loop early if a greater digit is found
                }
            }
        }
        // If no digit was removed within the loop, handle remaining cases
        if (ind == -1) {
            if (number.charAt(n - 1) == digit) {
                lastInd = n - 1;
            }
            if (lastInd < n - 1) {
                ind = lastInd;
            } else {
                ind = lastInd - 1; // If last digit is the only instance of the digit, remove the second-to-last digit
            }
        }

        return number.substring(0, ind) + number.substring(ind + 1);
    }
}
