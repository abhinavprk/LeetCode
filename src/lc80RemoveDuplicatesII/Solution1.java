package lc80RemoveDuplicatesII;

public class Solution1 {
    public static void main(String[] args) {
        /*System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1,1,1,1}));
        System.out.println(removeDuplicates(new int[]{1,2,3,4}));*/
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    private static int removeDuplicates(int[] nums) {
        // Initialize the counter and the second pointer.
        int moveIndex = 1;
        int count = 1;
        // Start from the second element of the array and process
        // elements one by one.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is a duplicate, increment the count.
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "moveIndex" in the array
            //When count > 2, the moveIndex will not move forward, but only i will move forward.
            // This will help copying the unique elements in the place of the elements that occur more
            //than 2 times.
            if (count <= 2) {
                nums[moveIndex] = nums[i];
                moveIndex++;
            }
        }
        return moveIndex;
    }
}
