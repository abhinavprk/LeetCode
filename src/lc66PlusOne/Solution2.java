package lc66PlusOne;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        //Move along the input array starting from the end
        for (int i = n - 1; i >= 0; --i) {
            //Set all the nines at the end of the array to zeros
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                //Here we have the rightmost not-nine
                // Increase this rightmost not-nine by 1
                digits[i]++;
                // and the job is done
                return digits;
            }
        }

        // We're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
