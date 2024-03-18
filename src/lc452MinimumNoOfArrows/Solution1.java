package lc452MinimumNoOfArrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16},{2, 8},{1, 6},{7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2},{3, 4},{5, 6},{7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2},{2, 3},{3, 4},{4, 5}}));
    }
    private static int findMinArrowShots(int[][] points) {
        List<int[]> listArr = Arrays.stream(points).sorted(Comparator.comparingInt(a->a[0])).toList();
        int shots = 1;
        int x = listArr.getFirst()[0];
        int y = listArr.getFirst()[1];
        for (int[] val : listArr){
            int p = val[0];
            int q = val[1];
            if((p >= x) && (p<=y)){
                y = Math.min(y,q);
            }else if(p > y){
                shots++;
                x = p;
                y = q;
            }
           // System.out.println(Arrays.toString(val));
        }
        return shots;
    }
}
