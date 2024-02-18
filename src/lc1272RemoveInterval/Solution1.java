package lc1272RemoveInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] [] intervals = {{0,2},{3,4},{5,7}};
        int[] toBeRemoved = {1,6};
        System.out.println(removeInterval(intervals,toBeRemoved));

        int[] [] intervalsA = {{0,5}};
        int[] toBeRemovedA = {2,3};
        System.out.println(removeInterval(intervalsA,toBeRemovedA));

        int[] [] intervalsB = {{-5,-4}, {-3,-2}, {1,2}, {3,5}, {8,9}};
        int[] toBeRemovedB = {-1,4};
        System.out.println(removeInterval(intervalsB,toBeRemovedB));

        int[] [] intervalsC = {{0,100}};
        int[] toBeRemovedC = {0,50};
        System.out.println(removeInterval(intervalsC,toBeRemovedC));
    }

    private static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int removeLeft = toBeRemoved[0];
        int removeRight = toBeRemoved[1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (((left <= removeLeft) && (removeRight <= right))) {
                //The left index and right index of removal is between this range
                //The range has to be split
                if(left != removeLeft) {
                    List<Integer> range = new ArrayList<>();
                    range.add(left);
                    range.add(removeLeft);
                    result.add(range);
                }
                if(right != removeRight) {
                    List<Integer> rangeB = new ArrayList<>();
                    rangeB.add(removeRight);
                    rangeB.add(right);
                    result.add(rangeB);
                }
            } else if ((left <= removeLeft) && (removeLeft <= right)) {
                //The left index of removal is between this range
                List<Integer> range = new ArrayList<>();
                range.add(left);
                range.add(removeLeft);
                result.add(range);
            } else if ((left <= removeRight) && (right >= removeRight)) {
                //The right index of removal is between this range
                List<Integer> range = new ArrayList<>();
                range.add(removeRight);
                range.add(right);
                result.add(range);
            } else if (!((left > removeLeft) && (right < removeRight))) {
                //The left or right index is not in this range
                //Add this range to resulting loop
                List<Integer> range = new ArrayList<>();
                range.add(left);
                range.add(right);
                result.add(range);
            }

        }
        return result;
    }
}
