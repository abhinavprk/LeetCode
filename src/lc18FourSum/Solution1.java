package lc18FourSum;

import javax.swing.event.TableColumnModelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(fourSum(new int[]{2,2,2,2,2},8));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i+1; j < nums.length - 2; j++) {
                int sumIJ = nums[i] + nums[j];
                for (int k = j+1; k < nums.length - 1; k++) {
                    int sumIJK = sumIJ + nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        int sum = sumIJK + nums[l];
                        if(sum == target){
                            List<Integer> indices = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(indices);
                            if(!result.contains(indices)) {
                                result.add(indices);
                            }
                        }
                    }
                }
            }

        }

        return result;
    }
}
