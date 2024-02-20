package lc268MissingNumber;

public class Solution6 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        int diff = 0;
        for (int i = 0; i < input.length; i++) {
            diff = diff + input[i] - i ;
        }
        return input.length - diff;
    }
}
