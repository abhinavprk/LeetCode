package lc442FindAllDuplicatesInArray;

import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length ; i++){
            int curr = Math.abs(nums[i]) - 1;
            if(nums[curr] < 0){
                ans.add(curr+1);
            }
            nums[curr] = nums[curr] * -1;
        }
        return ans;
    }
}
