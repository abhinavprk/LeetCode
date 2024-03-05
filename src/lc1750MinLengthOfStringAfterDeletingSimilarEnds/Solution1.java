package lc1750MinLengthOfStringAfterDeletingSimilarEnds;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(minimumLength("abbbbbbbbbbbbbbbbbbba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    private static int minimumLength(String s) {

        char[] chars = s.toCharArray();

        Deque<Character> deque = new LinkedList<>();
        for (char val : chars) {
            deque.add(val);
        }
        while (deque.size() > 1 && (deque.peekFirst() == deque.peekLast())) {
            char curr = deque.peekFirst();
            while (deque.size() > 1  && ((deque.peekFirst()==curr)||(deque.peekLast()==curr)) ) {
                if ((deque.peekFirst() == curr) && (deque.peekLast() == curr)) {
                    deque.removeFirst();
                    deque.removeLast();
                } else if (deque.peekFirst() == curr) {
                    deque.removeFirst();
                } else if(deque.peekLast() == curr){
                    deque.removeLast();
                }
            }
            if((deque.size() == 1) && deque.peek() == curr){
                deque.remove();
            }

        }
        return deque.size();

    }
}
