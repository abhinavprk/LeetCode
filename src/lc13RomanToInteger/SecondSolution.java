package lc13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class SecondSolution {

    public static void main(String[] args) {
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);
        int number = 0;
        for (int arrIndex = 0; arrIndex < s.length(); arrIndex++) {
            if ((arrIndex < s.length() - 1)
                    && (symbolMap.get(s.charAt(arrIndex)) < symbolMap.get(s.charAt(arrIndex + 1)))) {
                number -= symbolMap.get(s.charAt(arrIndex));
            } else {
                number += symbolMap.get(s.charAt(arrIndex));
            }
        }
        return number;
    }
}
