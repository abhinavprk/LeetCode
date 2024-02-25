package lc28FindFirstOccuranceInString;

public class Solution3 {
    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";

        System.out.println(getFirstOccurrence(haystack, needle));
    }

    private static int getFirstOccurrence(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
