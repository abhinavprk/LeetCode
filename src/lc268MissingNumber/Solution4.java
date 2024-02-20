package lc268MissingNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    public static void main(String[] args) {
        int [] input = {3,0,1};

        System.out.println(missingNumber(input));
    }

    private static int missingNumber(int[] input) {
        Set<Integer> valSet = new HashSet<>();
        int missingVal = -1;
        for(int val : input){
            valSet.add(val);
        }
        for(int num = 0; num <= input.length; num++){
            if(!valSet.contains(num)){
                missingVal = num;
            }
        }
        return missingVal;
    }
}
