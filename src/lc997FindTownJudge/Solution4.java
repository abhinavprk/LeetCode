package lc997FindTownJudge;

import java.util.Arrays;

public class Solution4 {
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
        //Every index except 0 in the arrays below represents each person in the town.
        //The sub-index 0 represents the number of people a person trusts
        //The sub-index 1 represents the number of people who trust the person
        int [][] trustRelationShipCount = new int[n+1][2];
        for (int[] val : trust) {
            trustRelationShipCount[val[0]][0]++;
            trustRelationShipCount[val[1]][1]++;
        }
        for (int[] val : trustRelationShipCount){
            System.out.println(Arrays.toString(val));
        }
        //Start with 1 because person 0 doesn't exist.
        for (int i = 1; i < n+1; i++) {
            if((trustRelationShipCount[i][0] == 0) && (trustRelationShipCount[i][1] == n-1)){
                judge = i;
                break;
            }
        }

        return judge;
    }
}
