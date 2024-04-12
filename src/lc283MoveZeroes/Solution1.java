package lc283MoveZeroes;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(moveZeroes(input)));
        int[] input2 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        System.out.println();
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(moveZeroes(input2)));

    }

    /*
    Time Complexity:

    Inner loop (while loop): This loop iterates as long as k encounters zeros within the remaining elements (k < nums.length - 1 and nums[k] == 0). In the worst case, it might iterate through all the remaining elements (all zeros after the current i). Let z represent the number of zeros after i. The inner loop's time complexity is O(z).
    Outer loop (for loop): This loop iterates nums.length - 1 times (excluding the last element as it's not compared). However, the inner loop's execution within each iteration depends on z.
    In the best case (no zeros), the inner loop doesn't execute, and the outer loop has a constant time complexity (O(1)) per iteration.
    In the worst case (all elements after i are zeros), the inner loop's complexity dominates, leading to O(z) per iteration.
    Overall Time Complexity:

    To analyze the overall complexity, we need to consider the average behavior of the inner loop across all outer loop iterations.
    If the number of zeros is evenly distributed throughout the array, the average number of zeros encountered by the inner loop in each iteration (z) would be proportional to the total number of zeros (Z) divided by the number of non-zero elements (N).
    Therefore, the average inner loop complexity would be O(Z / N).
    Multiplying this by the outer loop's iterations (nums.length - 1), we get an overall time complexity of O((Z / N) * (nums.length - 1)) which can be simplified to O(Z).
    Space Complexity:

    The code only uses a constant amount of extra space for variables i, j, and k. No additional data structures are created based on the input size.
    Therefore, the space complexity is O(1).
    In summary:

    Time complexity: O(Z), where Z is the number of zeros in the input array.
    Space complexity: O(1).
    Key Points:

    The time complexity depends on the distribution of zeros in the input array. If zeros are clustered, the inner loop might run more often, leading to a slightly higher effective time complexity in practice.
    This analysis assumes the operations within the loops (comparisons, assignments) take constant time. In reality, these operations might have slightly different complexities depending on the data types and operations involved. However, for asymptotic analysis, we typically focus on the dominant terms.
     */
    private static int[] moveZeroes(int[] nums) {
        for (int i = 0, j = i + 1; i < nums.length - 1; i++, j++) {
            int k = j;
            if ((nums[i] == 0)) {
                while ((k < nums.length - 1) && (nums[k] == 0)) {
                    k++;
                }
                nums[i] = nums[k];
                nums[k] = 0;
            }
            if (k == nums.length - 1) {
                break;
            }
        }
        return nums;
    }
}
