package lc1642FurthestBuildingReach;

import java.util.PriorityQueue;
import java.util.Queue;

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
        // Add heights in the heap where the highest number of bricks added will be of max priority and will be removed first
        //This way the bricks will be allocated to the lowest possible heights only.
        Queue<Integer> brickAllocations = new PriorityQueue<>((a,b)->(b-a));
        for (int building = 0; building < heights.length - 1; building++) {
            int climb= heights[building+1] - heights[building];
            if(climb > 0){
                //When climb is greater than 0 then only it is needed to add bricks or ladders
                //Add bricks first
                brickAllocations.add(climb);
                bricks = bricks - climb;
                //If bricks are negative and ladders are as well zero, no more jump possible
                if(bricks < 0 && ladders == 0){
                    return building;
                } else if(bricks < 0) {
                    //If ladders still available, use them and retrieve bricks so that they can be used for next jump if possible
                   bricks = bricks + brickAllocations.remove();
                   ladders--;
                }
            }
        }
        //If we are here, this means that all the buildings have been reached
        return heights.length-1;
    }
}
