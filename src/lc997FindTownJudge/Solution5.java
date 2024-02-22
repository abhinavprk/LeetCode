package lc997FindTownJudge;

import java.util.Arrays;

public class Solution5 {
    public static void main(String[] args) {
        int[][] trust = {{1,3}, {2,3}, {3,1}};
        int n = 3;
        System.out.println(findJudge(n, trust));
        int[][] trust1 = {{1,3}, {2,3}};
        int n1 = 3;
        System.out.println(findJudge(n1, trust1));

    }

    private static int findJudge(int n, int[][] trust) {
        int judge = -1;
        //Each person gains 1 "point" for each person they are trusted by, and loses 1 "point"
        // for each person they trust. Then at the end, the town judge, if they exist,
        // must be the person with N - 1 "points".
        int [] trustScore = new int[n+1];
        for (int[] val : trust) {
            trustScore[val[0]] --;
            trustScore[val[1]] ++;
        }
        //Start with 1 because person 0 doesn't exist.
        for (int i = 1; i < n+1; i++) {
            if((trustScore[i] == n-1)){
                judge = i;
                break;
            }
        }

        return judge;
    }
}
