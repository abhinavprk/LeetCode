package lc268MissingNumber;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        Arrays.sort(input);
        int missingNumber = -1;
        if(input[input.length-1] != input.length){
            missingNumber = input.length;
        } else if(input[0] != 0){
            missingNumber = 0;
        }
        for (int i = 1; i < input.length ; i++) {
            if((input[i] != i)){
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }
}
