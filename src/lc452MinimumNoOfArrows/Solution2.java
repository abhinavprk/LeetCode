package lc452MinimumNoOfArrows;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    /*
    Time Complexity:

    Sorting: The Arrays.sort operation has a time complexity of O(n log n), where n is the number of
    points in the input array. This is the dominant part of the overall time complexity.
    Loop: The subsequent loop iterates through the sorted array once, performing constant-time
    operations within each iteration. This has a time complexity of O(n).
    Overall Time Complexity:

    Combining these, the overall time complexity of the method is O(n log n) due to the sorting step.

    Space Complexity:

    Auxiliary Space: The method does not use any extra data structures that grow with the input size.
    The space used for variables like shots, x, y, p, and q is constant, as is the space for any temporary
    variables used during the sorting process.
    Sorting Space: The sorting algorithm might use some additional space internally, but this is
    typically a small constant factor relative to the input size.
    Overall Space Complexity:

    Therefore, the overall space complexity of the method is O(1), indicating that it uses a constant
    amount of extra space regardless of the input size.
     */
    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int shots = 1;
        int x = points[0][0];
        int y = points[0][1];
        for (int[] val : points) {
            int p = val[0];
            int q = val[1];
            if ((p >= x) && (p <= y)) {
                y = Math.min(y, q);
            } else if (p > y) {
                shots++;
                x = p;
                y = q;
            }
        }
        return shots;
    }
}
