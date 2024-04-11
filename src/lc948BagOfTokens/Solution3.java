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

    /*
    The time and space complexity of the bagOfTokenScore method are:

    Time Complexity: O(n * log(n))
    Space Complexity: O(n)
    Here's a breakdown of why:

    Time Complexity:

    Sorting the tokens using Arrays.sort takes O(n * log(n)) time in the worst case, where n is the number of tokens. This is the dominant factor in the time complexity.
    The while loop iterates over the deque at most n times (once for each token).
    Inside the loop, the operations like deque.peekFirst(), deque.pollFirst(), deque.pollLast() are typically constant time operations for a deque implemented using a linked list.
    Space Complexity:

    The method creates a deque to store the tokens. In the worst case, all tokens are added to the deque, leading to a space complexity of O(n).
    Other variables like score and power are constant space overhead.
    Overall, the sorting step dominates the time complexity, making it O(n * log(n)). The space complexity is linear in the number of tokens, O(n).
     */
    private static int bagOfTokenScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        Deque<Integer> deque = new LinkedList<>();
        for (int val : tokens) {
            deque.add(val);
        }
        while (!deque.isEmpty()) {
            // When we have enough power, play lowest token face-up
            if (power >= deque.peekFirst()) {
                score++;
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
