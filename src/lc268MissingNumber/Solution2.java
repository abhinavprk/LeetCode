package lc268MissingNumber;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        int sum = 0;
        int n = input.length;
        for (int val : input) {
            sum = sum + val;
        }
        return ((n * (n+1))/2) - sum;
    }
}
