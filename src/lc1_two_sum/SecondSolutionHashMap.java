package lc1_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Use hashMap to store values and compare later on with it
 *
 */
public class SecondSolutionHashMap {

    public static void main(String[] args) {

        int [] nums = new int[]{2, 5, 8, 3};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2]; // The resulting array can contain only two elements
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int inputIndex = 0; inputIndex < nums.length ; inputIndex++){
            int complement = target - nums[inputIndex];
            if(complementMap.containsKey(complement)){
                result[0] = complementMap.get(complement); //complement will always be smaller
                result[1] = inputIndex;
                break;
            } else {
                complementMap.put(nums[inputIndex], inputIndex);

            }

        }
        return result;
    }
}
