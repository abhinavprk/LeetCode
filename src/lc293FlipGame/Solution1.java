package lc293FlipGame;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        String currentState = "++++";
        System.out.println(generatePossibleNextMoves(currentState));
    }

    private static List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if ((currentState.charAt(i) == '+') && (currentState.charAt(i) == currentState.charAt(i + 1))) {
                String val;
                if (i < currentState.length() - 2) {
                    val = currentState.substring(0, i) + "--"
                            + currentState.substring(i + 2);
                } else {
                    val = currentState.substring(0, i) + "--";
                }
                result.add(val);
            }

        }
        return result;
    }
}
