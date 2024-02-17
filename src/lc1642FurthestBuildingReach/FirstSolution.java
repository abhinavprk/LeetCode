package lc1642FurthestBuildingReach;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/description/
 */

public class FirstSolution {
    public static void main(String[] args) {

        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int ladders = 1;
        int bricks = 5;
        System.out.println(furthestReachable(heights, bricks, ladders));
    }

    private static int furthestReachable(int[] heights, int bricks, int ladders) {
        // Add heights in the heap where the lowest height will be of max priority and will be removed first
        //This way the ladders will be allocated to the highest possible heights only.
        Queue<Integer> ladderAllocations = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int building = 0; building < heights.length - 1; building++) {
            int climb= heights[building+1] - heights[building];
            if(climb > 0){
                //When climb is greater than 0 then only it is needed to add bricks or ladders
                //Add Ladders first
                ladderAllocations.add(climb);
                if(ladderAllocations.size() > ladders){
                    //If ladders allocated positions are greater than the ladders available, take the ladder out. It will remove the
                    // ladder for the lowest height from the Queue
                    //Now use the bricks for the removed ladder
                    bricks = bricks - ladderAllocations.remove();
                    //If bricks are negative, there is no more jump possible.
                    if(bricks < 0){
                        return building;
                    }
                }
            }
        }
        return heights.length-1;
    }
}
