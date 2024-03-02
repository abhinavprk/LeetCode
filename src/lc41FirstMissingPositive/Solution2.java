package lc41FirstMissingPositive;

/*
O(n) solution
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));

    }

    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Base case. Find if there is 1 in the array
        int contains = 0;
        for (int num : nums) {
            if (num == 1) {
                contains++;
                break;
            }
        }
        //If there is no 1 in array, this would be the answer
        if (contains == 0) {
            return 1;
        }
        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this conversion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++) {
            if ((nums[i] <= 0) || (nums[i] > n)) {
                nums[i] = 1;
            }
        }
        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }
        //If value at an index in positive, that is the missing index
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0){
            return n;
        }
        //If code comes here, this means that the all the indexes have negative values,
        //This means that the missing positive number is the n+1
        return n+1;
    }
}
