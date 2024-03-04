package lc948BagOfTokens;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(bagOfTokenScore(tokens, power));
    }

    private static int bagOfTokenScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int points = 0;
        int small = 0;
        int big = tokens.length - 1;
        while (small <= big) {
            if (points <= 0) {
                //Can only play Face Up to gain points if it has enough power
                int currMin = tokens[small];
                if (power >= currMin) {
                    // Has enough power to play Face up and gain one point
                    //Reduce the power by spent power token[small]
                    power -= currMin;
                    //Gain one point
                    points++;
                    //the current token is played
                    small++;
                } else {
                    //If it doesn't have enough power the game can't go ahead because
                    //token[small] is the minimum available token to play. Also, there is no point
                    //so can't play FaceDown too
                    break;
                }
            } else {
                //With points in hand can play face up as well as face down
                int currMax = tokens[big];
                int currMin = tokens[small];
                if(currMin > (power + currMax)){
                    //In this case, even of we lose points to gain more power, we will not get
                    //enough power to gain new points, so no need to lose points anymore
                    break;
                }
                //If it has minimum power to spend to gain more points gain points
                if (power >= currMin) {
                    power -= currMin;
                    points++;
                    small++;
                } else {
                    //not enough power to gain points, gain power but only if big == small. If big!=small, then only
                    //we will be left with a small to gain new point
                    if(small != big){
                    power += currMax;
                    points--;
                    }
                    big--;
                }

            }
        }

        return points;
    }
}
