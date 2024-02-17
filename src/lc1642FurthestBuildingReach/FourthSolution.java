package lc1642FurthestBuildingReach;

import java.util.*;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/description/
 */
public class FourthSolution {
    public static void main(String[] args) {

        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int ladders = 1;
        int bricks = 5;
        System.out.println(furthestReachable(heights, bricks, ladders));
    }

    private static int furthestReachable(int[] heights, int bricks, int ladders) {
        //Get climbs along with their indexes in a List
        List<Climbs> climbs = new ArrayList<>();
        for (int height = 0; height < heights.length - 1; height++) {
            int climb = heights[height + 1] - heights[height];
            if(climb > 0) {
                climbs.add(new Climbs(climb, height));
            }
        }
        //Sort the climbs
        climbs = climbs.stream().sorted(Comparator.comparingInt(Climbs::climb)).toList();
        int beg = 0;
        int end = heights.length - 1;
        while (beg < end) {
            int center = beg + (end - beg + 1) / 2;
            if (isBuildingReachable(center, climbs, bricks, ladders)) {
                beg = center;
            } else {
                end = center - 1;
            }
        }
        return end;
    }

    private static boolean isBuildingReachable(int index, List<Climbs> climbs, int bricks, int ladders){
        for (Climbs height : climbs) {
            //If the location fo current climb is greater than or equal to current index, we need no further climb
            if (height.location() < index) {
                //For every climb use bricks first
                if (height.climb() <= bricks) {
                    //if bricks are not sufficient and ladders are available, use ladder
                    bricks = bricks - height.climb();
                } else if (ladders > 0) {
                    //If bricks are not sufficient and ladders are not there, the building can't be reached
                    ladders--;
                } else {
                    return false;
                }
            }
        }
        //If we are able to traverse through all the climbs, the building is reachable.
        return true;
    }
}

record Climbs(int climb, int location) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Climbs climbs = (Climbs) o;
        return climb() == climbs.climb();
    }

    @Override
    public int hashCode() {
        return Objects.hash(climb());
    }
}
