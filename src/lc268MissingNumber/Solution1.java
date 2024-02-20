package lc268MissingNumber;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        Arrays.sort(input);
        int missingNumber = -1;
        for (int i = 0; i <= input.length; i++) {
            if((i == input.length) || (input[i] != i)){
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
}
