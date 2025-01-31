package lc1266MinimumTimeVisitingAllPoints.ProblemStatement;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(getMinTimeToVisitAllPoints(new int [][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(getMinTimeToVisitAllPoints(new int [][]{{3, 2}, {-2, 2}}));
    }

    private static int getMinTimeToVisitAllPoints(int[][] points) {
            int time = 0;
            for(int i = 0; i < points.length - 1; i++){
                int xTime = Math.abs(points[i+1][0] - points[i][0]);
                int yTime = Math.abs(points[i+1][1] - points[i][1]);
                time = time + (Math.max(xTime, yTime));
            }
        return time;
    }
}
