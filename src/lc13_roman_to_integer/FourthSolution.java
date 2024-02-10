package lc13_roman_to_integer;

public class FourthSolution {

    public static void main(String[] args) {
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int number = 0;
        int curVal = translate(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int nextVal = translate(s.charAt(i));
            if (nextVal > curVal){
                number -= curVal;
            } else {
                number += curVal;
            }
            curVal = nextVal;
        }
        number += curVal;
        return number;
    }

    private static int translate(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
