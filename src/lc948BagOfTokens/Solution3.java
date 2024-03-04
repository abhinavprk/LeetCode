package lc948BagOfTokens;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(bagOfTokenScore(tokens, power));
    }

    private static int bagOfTokenScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        Deque<Integer> deque = new LinkedList<>();
        for (int val: tokens){
            deque.add(val);
        }
        while (!deque.isEmpty()) {
            // When we have enough power, play lowest token face-up
            if (power >= deque.peekFirst()) {
                score ++;
                power -= deque.pollFirst();
                // We don't have enough power to play a token face-up
                // If there is at least one token remaining,
                // and we have enough score, play highest token face-down
            } else if ((deque.size() > 1) && score > 0) {
                score--;
                power += deque.pollLast();
                // We don't have enough score, power, or tokens
                // to play face-up or down and increase our score
            } else {
                return score;
            }
        }
        return score;
    }
}
