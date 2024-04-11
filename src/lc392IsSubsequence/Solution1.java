package lc392IsSubsequence;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdcg"));
    }

    private static boolean isSubsequence(String s, String t) {
        boolean result = true;
        int j = 0;
        for(int i = 0; i< t.length(); i++){
            if(j<s.length()){
                char curr = s.charAt(j);
                if(curr == t.charAt(i)){
                    j++;
                }
            }
        }
        if(j != s.length()){
            result = false;
        }
        return result;
    }
}
