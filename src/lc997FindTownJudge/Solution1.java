package lc997FindTownJudge;

import java.util.SortedSet;
import java.util.TreeSet;

public class Solution1 {
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
        SortedSet<Integer> peopleWhoTrust = new TreeSet<>();
        //Create a sorted set of people who trust other people
        for(int [] val: trust){
            peopleWhoTrust.add(val[0]);
        }
        System.out.println(peopleWhoTrust);
        //Since everyone trusts the town judge, only person missing out of the peopleWhoTrust will be the
        //town judge, because he trusts nobody.The size of set must be n-1 if a judge exists
        if(peopleWhoTrust.size() == n-1){
            int probableJudge = -1;
            int i = 1;
            for(int val: peopleWhoTrust){
                if(i!= val){
                    probableJudge = i; //if i is missing, so it is potential judge
                    break;
                }
                i++;
            }
            //If all n-1 values traversed and probableJudge is still -1, it would be n
            if(i==n){
                probableJudge = n;
            }

            //Check if everyone else trusts the judge. The count of people trusting the judge should be n-1
            int noOfTrusts = 0;
            for(int [] val: trust){
                if(val[1] == probableJudge){
                    noOfTrusts++;
                }
            }
            System.out.println("number of trusts: " + noOfTrusts);
            System.out.println("Probable judge: " + probableJudge);
            if(noOfTrusts == (n-1)){
                judge = probableJudge;
            }
        }
        return judge;
    }
}
