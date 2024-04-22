package lc56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        int[][] result1 = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        int[][] result2 = merge(new int[][]{{1, 4}, {4, 5}});
    }

    private static int[][] merge(int[][] intervals) {
        //sort the given intervals:
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // select an interval:
            int start = intervals[i][0];
            int end = intervals[i][1];

            //Skip all the merged intervals:
            //If the end of current range is smaller or equal to the end of the last range in the ans,
            //This means the current range will fall in the range already added to the ans
            if (!ans.isEmpty() && end <= ans.getLast()[1]) {
                continue;
            }

            //check the rest of the intervals:
            //If the start of the current range is smaller than the end of the last range
            //the ranges can be merged, so the new end will be the end that is greater.out of the two ends
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= end) {
                    //Choose the largest of the two ends because the ranges are ordered by the start not by the end.
                    end = Math.max(end, intervals[j][1]);
                } else {
                    // Otherwise come out of the loop
                    break;
                }
            }
            // Add to the answer
            ans.add(new int[]{start, end});
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
