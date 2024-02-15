package lc26RemoveDuplicates;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class SecondSolution {
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(input));
    }

    private static int removeDuplicate(int[] input) {
        int k=1;
        for (int i = 1; i < input.length; i++) {
            if(input[i] != input[i-1]){
                input[k] = input[i];
                k++;
            }
        }
        return k;
        }
}
