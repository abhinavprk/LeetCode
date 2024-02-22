package lc997FindTownJudge;

import java.util.SortedSet;
import java.util.TreeSet;

public class Solution3 {
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
        //The number of people trusted by each person
        int [] noOfPeopleTrusted = new int[n+1];
        //The number of people who trust each person
        int [] noOfPeopleTrustedBy = new int[n+1];
        for (int [] trustRelationShip : trust){
            noOfPeopleTrusted[trustRelationShip[0]]++;
            noOfPeopleTrustedBy[trustRelationShip[1]] ++;
        }
        //Start with 1 because person 0 doesn't exist.
        for (int i = 1; i < n+1; i++) {
            if((noOfPeopleTrustedBy[i] == n -1) && (noOfPeopleTrusted[i] == 0)){
                judge = i;
                break;
            }
        }

        return judge;
    }
}
