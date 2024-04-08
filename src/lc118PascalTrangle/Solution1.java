package lc118PascalTrangle;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(6));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        last.add(1);
        answer.add(last);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < i-1; j++){
                row.add(last.get(j) + last.get(j+1));
            }
            row.add(1);
            answer.add(row);
            last = row;
        }

        return answer;

    }
}
