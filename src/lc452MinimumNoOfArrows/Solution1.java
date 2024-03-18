package lc452MinimumNoOfArrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    /*
    The time complexity of the provided method is  O(n log n) and the space complexity is O(n).

    Here's a breakdown of the complexity:

    Time Complexity:

    Sorting the input array points using Arrays.stream().sorted() takes O(n log n) time in the worst case,
    where n is the number of balloons. This is because most sorting algorithms used in Java have this time complexity.

    Space Complexity:

    Converting the input array points to a List using toList() creates a new data structure. In the worst case,
    this new list could take up to O(n) space to store all the elements from the original array.

    Additional Notes:

    The space complexity of the code could be potentially improved by sorting the original array points in-place
    instead of creating a new List. However, this would require modifying the original input array,
     which might not be desirable in some cases.
    The code snippet uses an extra variable shots to keep track of the minimum number of arrows needed.
    This contributes to a constant extra space complexity of O(1), which is negligible compared to the O(n)
    space used by the list.
    Overall, the dominant factor in both time and space complexity is the sorting operation.
    Therefore, the time complexity is  O(n log n) and the space complexity is O(n).
     */
    private static int findMinArrowShots(int[][] points) {
        List<int[]> listArr = Arrays.stream(points).sorted(Comparator.comparingInt(a -> a[0])).toList();
        int shots = 1;
        int x = listArr.getFirst()[0];
        int y = listArr.getFirst()[1];
        for (int[] val : listArr) {
            int p = val[0];
            int q = val[1];
            if ((p >= x) && (p <= y)) {
                y = Math.min(y, q);
            } else if (p > y) {
                shots++;
                x = p;
                y = q;
            }
            // System.out.println(Arrays.toString(val));
        }
        return shots;
    }
}
