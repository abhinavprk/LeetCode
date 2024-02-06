package two_sum;

import java.util.Arrays;

public class FirstSolution {

    public static void main(String[] args) {

        int [] nums = new int[]{2, 1, 3, 4, 5, 8};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2]; // The resulting array can contain only two elements
        checkSum:
        for(int inputArrayIndex = 0; inputArrayIndex < nums.length - 1 ; inputArrayIndex++){
            int firstNumber = nums[inputArrayIndex];
            for(int compareArrayIndex = inputArrayIndex + 1; compareArrayIndex < nums.length; compareArrayIndex++){
                int secondNumber = nums[compareArrayIndex];
                if((target - secondNumber == firstNumber)) {
                    //numbers found, add the indexes in the result array
                    result[0] = inputArrayIndex;
                    result[1] = compareArrayIndex;
                    break checkSum; // break the loop
                }
            }
        }
        return result;
    }
}
