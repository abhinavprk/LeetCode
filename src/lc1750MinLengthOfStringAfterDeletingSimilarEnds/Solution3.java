package lc1750MinLengthOfStringAfterDeletingSimilarEnds;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(minimumLength("abbbbbbbbbbbbbbbbbbba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    private static int minimumLength(String s) {
        int beg=0;
        int end = s.length()-1;
        while(beg< end){
            char front = s.charAt(beg);
            char back = s.charAt(end);
            if(front == back){
                while((beg<=end)&&(s.charAt(beg) ==  front)){
                    beg++;
                }
                while((beg < end)&&(s.charAt(end) == front)){
                    end--;
                }
            }else{
                break;
            }
        }
        return end-beg+1;
    }
}
