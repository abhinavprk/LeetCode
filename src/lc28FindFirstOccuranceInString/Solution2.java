package lc28FindFirstOccuranceInString;

public class Solution2 {
    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";

        System.out.println(getFirstOccurrence(haystack, needle));
    }

    private static int getFirstOccurrence(String haystack, String needle) {
        int needleLocation = -1;
        if (needle.length() <= haystack.length()) {
            int hayIndex = 0;
            for (int needleIndex = 0; needleIndex < needle.length(); needleIndex++) {
                if(hayIndex > (haystack.length() - needle.length())){
                    break;
                }
                if (haystack.charAt(hayIndex + needleIndex) != needle.charAt(needleIndex)) {
                    hayIndex++;
                    needleIndex = -1;
                }
                if ((needleIndex == needle.length() - 1) && (haystack.charAt(hayIndex + needleIndex) == needle.charAt(needleIndex))) {
                    needleLocation = hayIndex;
                    break;
                }
            }
        }
        return needleLocation;
    }
}
