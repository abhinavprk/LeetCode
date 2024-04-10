package lc950RevelCardInAscendingOrder;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{11, 1000})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{11, 1000, 500})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1, 2, 3, 4})));
    }

    private static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indexQueue.offer(i);
        }
        int deckIndex = 0;
        boolean pushBack = false;
        while (!indexQueue.isEmpty()) {
           int currIndex = indexQueue.poll();
           if(pushBack){
               indexQueue.add(currIndex);
           } else {
               res[currIndex] = deck[deckIndex++];
           }
           pushBack = !pushBack;
        }
        return res;
    }
}
