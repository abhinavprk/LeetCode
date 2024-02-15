package lc26RemoveDuplicates;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class FirstSolution {
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(input));
    }

    private static int removeDuplicate(int[] input) {
            Set<Integer> duplicates = new HashSet<>();
            int k=0;
            int uniqueIndex = -1;
            for (int i = 0; i < input.length; i++) {
                int curr = input[i];
                if(!duplicates.contains(curr)){
                    input[uniqueIndex + 1] = curr;
                    uniqueIndex++;
                    duplicates.add(curr);
                    k++;
                }
            }
            return k;
        }
}
