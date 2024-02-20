package lc268MissingNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Approach #3 Bit Manipulation
 * Intuition
 * <p>
 * We can harness the fact that XOR is its own inverse to find the missing
 * element in linear time.
 * <p>
 * Algorithm
 * <p>
 * Because we know that nums contains nnn numbers and that it is missing
 * exactly one number on the range [0..n−1][0..n-1][0..n−1], we know that nnn definitely
 * replaces the missing number in nums. Therefore, if we initialize an integer
 * to nnn and XOR it with every index and value, we will be left with the
 * missing number. Consider the following example (the values have been sorted
 * for intuitive convenience, but need not be):
 *
 *
 * A better way to understand XOR solution is that if each number on an index was equal
 * to its corresponding index OR nums[i] == i then taking the XOR of all the indices and
 * all the values would have resulted in a perfect cancellation (ZERO ) and thus yielding
 * the missing number as n ( the highest number in range ). Now that can give a better clue
 * that not only all the indices and values but also
 * the highest number of range needs to be XORed to get the missing number
 */
public class Solution5 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        int missingVal = input.length;
        for(int num = 0; num < input.length; num++){
            missingVal = missingVal ^ num ^ input[num];
        }
        return missingVal;
    }
}
