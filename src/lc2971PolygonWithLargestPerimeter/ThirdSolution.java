package lc2971PolygonWithLargestPerimeter;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description
 */
public class ThirdSolution {
    public static void main(String[] args) {
       int[] input = {1, 12, 1, 2, 5, 50, 3};
       System.out.println(findLargestPerimeter(input));
       int[] input2 = {5, 5, 5};
       System.out.println(findLargestPerimeter(input2));
        int[] input3 = {300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987};
        System.out.println(findLargestPerimeter(input3));
    }

    private static long findLargestPerimeter(int[] input) {
        long highestPerimeter = -1;
        if (input.length < 3) {
            return highestPerimeter;
        }
        Arrays.sort(input);
        long totalSum = 0;
        for (int j : input) {
            totalSum = totalSum + j;
        }
        for (int i = input.length - 1; i > 1; i--) {
            long longest = input[i];
            if ((totalSum - longest) > longest) {
                highestPerimeter = totalSum;
                break;
            }
            totalSum = totalSum - longest;
        }
        return highestPerimeter;
    }
}
