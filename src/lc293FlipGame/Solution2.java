package lc293FlipGame;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        String currentState = "++++";
        System.out.println(generatePossibleNextMoves(currentState));
    }

    private static List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(currentState);
        for(int i=0;i<currentState.length()-1;i++){
            if(currentState.charAt(i)=='+' && currentState.charAt(i+1)=='+'){
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                ans.add(sb.toString());
                sb.setCharAt(i,'+');
                sb.setCharAt(i+1,'+');
            }
        }

        return ans;
    }
}
