package lc950RevelCardInAscendingOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{11, 1000})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{11, 1000, 500})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1, 2, 3, 4})));
    }

    private static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        List<Integer> res = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        for (int val : deck) {
            queue.add(val);
        }
        boolean add = true;
        while (!queue.isEmpty()) {
            int curr;
            if (add) {
                curr = queue.removeLast();
            } else {
                curr = res.removeLast();
            }
            res.addFirst(curr);
            add = !add;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
