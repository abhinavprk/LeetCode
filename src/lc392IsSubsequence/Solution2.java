package lc392IsSubsequence;

public class Solution2 {

    static String source;
    static String target;
    static int srcIndex;
    static int targetIndex;
    public static void main(String[] args) {
        //System.out.println(isSubsequence("abc","ahbgdc"));
        //System.out.println(isSubsequence("axc","ahbgdcg"));
        System.out.println(isSubsequence("abc","abc"));
    }

    private static boolean isSubsequence(String s, String t) {
        source = s;
        target = t;
        srcIndex = 0;
        targetIndex = 0;
        return getSubSequence(0, 0);
    }

    private static boolean getSubSequence(int srcIndex, int targetIndex) {
        if(srcIndex == source.length() ){
            return true;
        }
        if(targetIndex == target.length()){
            return false;
        }
        if(source.charAt(srcIndex) == target.charAt(targetIndex)){
            srcIndex++;
        }
        targetIndex++;
        return getSubSequence(srcIndex, targetIndex);
    }
}
