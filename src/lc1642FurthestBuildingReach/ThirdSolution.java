package lc1642FurthestBuildingReach;

import java.util.*;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/description/
 */
public class ThirdSolution {
    public static void main(String[] args) {

        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int ladders = 1;
        int bricks = 5;
        System.out.println(furthestReachable(heights, bricks, ladders));
    }

    private static int furthestReachable(int[] heights, int bricks, int ladders) {
        int beg = 0;
        int end = heights.length - 1;
        while (beg < end) {
            int center = beg + (end - beg + 1) / 2;
            if (isBuildingReachable(center, heights, bricks, ladders)) {
                beg = center;
            } else {
                end = center - 1;
            }
        }
        return end;
    }

    private static boolean isBuildingReachable(int index, int[] heights, int bricks, int ladders){
        List<Integer> climbs = new LinkedList<>();
        //Add all heights to jum in the list
        for (int building = 0; building <= index - 1; building++) {
            int height = heights[building + 1] - heights[building];
            if(height > 0){
                climbs.add(height);
            }
        }
        //Sort the list of climbs in ascending order
        Collections.sort(climbs);
        for (int height : climbs){
            //For every climb use bricks first
            bricks = bricks - height;
            if(bricks < 0 && ladders != 0){
                //if bricks are not sufficient and ladders are available, use ladder
                ladders--;
            } else if(bricks < 0){
                //If bricks are not sufficient and ladders are not there, the building can't be reached
                return false;
            }
        }
        //If we are able to traverse through all the climbs, the building is reachable.
        return true;
    }
}
