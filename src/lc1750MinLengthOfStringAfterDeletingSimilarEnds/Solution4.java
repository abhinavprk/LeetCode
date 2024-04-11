package lc1750MinLengthOfStringAfterDeletingSimilarEnds;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(minimumLength("abbbbbbbbbbbbbbbbbbba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    private static int minimumLength(String s) {
        return deleteSimilarEnds(s, 0, s.length() - 1);
    }
    // Deletes similar ends and returns remaining length
    private static int deleteSimilarEnds(String s, int begin, int end) {
        // The ends differ or meet in the middle
        if (begin >= end || s.charAt(begin) != s.charAt(end)) {
            return end - begin + 1;
        } else {
            char c = s.charAt(begin);

            // Delete consecutive occurrences of c from prefix
            while (begin <= end && s.charAt(begin) == c) {
                begin++;
            }

            // Delete consecutive occurrences of c from suffix
            while (end > begin && s.charAt(end) == c) {
                end--;
            }

            return deleteSimilarEnds(s, begin, end);
        }
    }
}
