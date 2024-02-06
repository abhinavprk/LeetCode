package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Use hashMap to store values and compare later on with it
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class FourthSolutionSlidingWindow {

    public static void main(String[] args) {

        int [] nums = new int[]{2, 5, 8, 3};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2]; // The resulting array can contain only two elements
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int inputIndex = 0; inputIndex < nums.length; inputIndex++){
            complementMap.put(nums[inputIndex], inputIndex );
        }
        for(int inputIndex = 0; inputIndex < nums.length ; inputIndex++){
            int complement = target - nums[inputIndex];
            //For duplicate entries, also check the index of the complement. It shouldn't be same.
            if(complementMap.containsKey(complement) && (complementMap.get(complement)!= inputIndex)){
                result[1] = complementMap.get(complement); //complement will always be smaller
                result[0] = inputIndex;
                break;
            }
        }
        return result;
    }
}
