package lc56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        int[][] result1 = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        int[][] result2 = merge(new int[][]{{1, 4}, {4, 5}});
    }

    private static int[][] merge(int[][] intervals) {
        //sort the given intervals:
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        for (int [] interval: intervals) {
            // if ans is empty, add the current interval to ans
            // if the end of last range in the ans is smaller than the start of the
            //current interval, add the current interval to the ans
            if(ans.isEmpty() || (ans.getLast()[1] < interval[0])){
                ans.add(interval);
            } else{
                //Else the start of the current interval is smaller than or equal to the
                //end of the last interval in the answer, this means that the end of the
                //last interval in the ans can be changed to the end of the current interval if
                //it is  bigger than the end of the last interval in the ans
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }

        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
