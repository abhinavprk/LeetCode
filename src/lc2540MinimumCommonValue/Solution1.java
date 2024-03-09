package lc2540MinimumCommonValue;

public class Solution1 {

    public static void main(String[] args) {

        System.out.println(getCommon(new int[] {1,2,3,6},new int[] {2,3,4,5} ));
        System.out.println(getCommon(new int[] {1,2,3,6},new int[] {5,7,8,9} ));
        System.out.println(getCommon(new int[] {1,2,3,9},new int[] {5,7,8,9} ));
        System.out.println(getCommon(new int[] {1,2,3,9},new int[] {1,7,8,9} ));
        System.out.println(getCommon(new int[] {1},new int[] {1,7,8,9} ));
        System.out.println(getCommon(new int[] {1},new int[] {1} ));
        System.out.println(getCommon(new int[] {1},new int[] {} ));
        System.out.println(getCommon(new int[] {},new int[] {} ));

    }
/*
Time Complexity:

O(min(m, n)), where m and n are the lengths of nums1 and nums2, respectively.

The while loop iterates at most until either num1Index or num2Index reaches the end of
its corresponding array, effectively processing a maximum of the smaller array's length.
Within the loop, operations like comparisons and index increments take constant time.
Space Complexity:

O(1), meaning it uses a constant amount of extra space regardless of input size.

The variables minCommon, num1Index, num2Index, num1Val, and num2Val occupy a fixed amount of memory,
 not depending on the input arrays' lengths.
 */
    private static int getCommon(int[] nums1, int[] nums2) {
        int minCommon = -1;
        int num1Index = 0;
        int num2Index = 0;
        while ((num1Index < nums1.length) && (num2Index < nums2.length)) {
            int num1Val = nums1[num1Index];
            int num2Val = nums2[num2Index];
            if (num1Val == num2Val) {
                minCommon = num1Val;
                break;
            }
            if (num1Val < num2Val) {
                num1Index++;
            } else {
                num2Index++;
            }
        }
        return minCommon;
    }

}
