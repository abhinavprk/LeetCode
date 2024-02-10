package lc13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class FirstSolution {

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
        char[] chars = s.toCharArray();
        for (int arrIndex = 0; arrIndex < chars.length;) {
            char valueAtIndex = chars[arrIndex];
            int value = switch (valueAtIndex) {
                case 'I' -> {
                    int yieldVal = 0;
                    if (arrIndex != chars.length - 1) {
                        char nextChar = chars[arrIndex + 1];
                        if (nextChar == 'V') {
                            yieldVal = symbolMap.get('V') - symbolMap.get('I');
                            arrIndex += 2;
                        } else if (nextChar == 'X') {
                            yieldVal = symbolMap.get('X') - symbolMap.get('I');
                            arrIndex += 2;
                        }
                    } else {
                        yieldVal = symbolMap.get('I');
                        arrIndex++;
                    }

                    yield yieldVal;
                }
                case 'X' -> {
                    int yieldVal = 0;
                    if (arrIndex != chars.length - 1) {
                        char nextChar = chars[arrIndex + 1];
                        if (nextChar == 'L') {
                            yieldVal = symbolMap.get('L') - symbolMap.get('X');
                            arrIndex += 2;
                        } else if (nextChar == 'C') {
                            yieldVal = symbolMap.get('C') - symbolMap.get('X');
                            arrIndex += 2;
                        }
                    } else {
                        yieldVal = symbolMap.get('X');
                        arrIndex++;
                    }

                    yield yieldVal;
                }
                case 'C' -> {
                    int yieldVal = 0;
                    if (arrIndex != chars.length - 1) {
                        char nextChar = chars[arrIndex + 1];
                        if (nextChar == 'D') {
                            yieldVal = symbolMap.get('D') - symbolMap.get('C');
                            arrIndex += 2;
                        } else if (nextChar == 'M') {
                            yieldVal = symbolMap.get('M') - symbolMap.get('C');
                            arrIndex += 2;
                        }
                    } else {
                        yieldVal = symbolMap.get('C');
                        arrIndex++;
                    }

                    yield yieldVal;
                }
                case 'V', 'L', 'D', 'M' -> {
                    arrIndex++;
                    yield symbolMap.get(valueAtIndex);
                }
                default -> 0;
            };
            number = number + value;
        }

        return number;
    }
}
