package lc13RomanToInteger;

public class ThirdSolution {

    public static void main(String[] args) {
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int number = 0;
        int val;
        for (int i = s.length()-1; i >= 0; i--) {
            val = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (4 * val < number){
                number -= val;
            } else {
                number += val;
            }
        }
        return number;
    }
}
