package lc1272RemoveInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved = {1, 6};
        System.out.println(removeInterval(intervals, toBeRemoved));

        int[][] intervalsA = {{0, 5}};
        int[] toBeRemovedA = {2, 3};
        System.out.println(removeInterval(intervalsA, toBeRemovedA));

        int[][] intervalsB = {{-5, -4}, {-3, -2}, {1, 2}, {3, 5}, {8, 9}};
        int[] toBeRemovedB = {-1, 4};
        System.out.println(removeInterval(intervalsB, toBeRemovedB));

        int[][] intervalsC = {{0, 100}};
        int[] toBeRemovedC = {0, 50};
        System.out.println(removeInterval(intervalsC, toBeRemovedC));
    }

    private static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int removeLeft = toBeRemoved[0];
        int removeRight = toBeRemoved[1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            // If there are no overlaps, add the interval to the list as is.
            if (left > removeRight || right < removeLeft) {
                result.add(Arrays.asList(left, right));
            } else {
                // Is there a left interval we need to keep?
                if (left < removeLeft) {
                    result.add(Arrays.asList(left, removeLeft));
                }
                // Is there a right interval we need to keep?
                if (right > removeRight) {
                    result.add(Arrays.asList(removeRight, right));
                }
            }

        }
        return result;
    }
}
