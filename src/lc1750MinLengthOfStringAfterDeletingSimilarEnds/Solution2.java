package lc1750MinLengthOfStringAfterDeletingSimilarEnds;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(minimumLength("abbbbbbbbbbbbbbbbbbba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    private static int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int beg=0;
        int end = chars.length-1;
        while(beg< end){
            char front = chars[beg];
            char back = chars[end];
            if(front == back){
                while((beg<=end)&&(chars[beg] ==  front)){
                    beg++;
                }
                while((beg < end)&&(chars[end] == front)){
                    end--;
                }
            }else{
                break;
            }
        }
        return end-beg+1;
    }
}
