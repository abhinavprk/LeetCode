package lc28FindFirstOccuranceInString;

public class Solution1 {
    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "issip";

        System.out.println(getFirstOccurrence(haystack, needle));
    }

    private static int getFirstOccurrence(String haystack, String needle) {
        int needleLocation = -1;
        if(needle.length() <= haystack.length()) {
            int hayIndex = 0;
            Outer:
            while(hayIndex <= haystack.length() - needle.length()) {
                int startIndex = hayIndex;
                for (int needleIndex = 0; needleIndex < needle.length(); needleIndex++) {
                    if(haystack.charAt(startIndex) != needle.charAt(needleIndex)){
                        break;
                    } else if ((needleIndex == needle.length()-1) && (haystack.charAt(startIndex) == needle.charAt(needleIndex))) {
                        needleLocation = hayIndex;
                        break Outer;
                    }
                    startIndex ++;
                }
                hayIndex ++;
            }
        }
        return needleLocation;
    }
}
