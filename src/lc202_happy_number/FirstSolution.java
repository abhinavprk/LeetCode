package lc202_happy_number;

import java.util.Hashtable;
import java.util.Map;

/**
 * O(nlogn) -- Time Complexity
 * O(n) --- Space complexity
 */
public class FirstSolution {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
    }

    private static boolean isHappy(int n) {
        int input = n;
        boolean isHappy = true;
        Map<Integer, Integer> inputMap = new Hashtable<>();
        while(input != 1){
            input = sumOfSquareDigits(input);
            if((input != 1) && inputMap.containsKey(input)){
                isHappy = false;
                break;
            } else {
                inputMap.put(input, 1);
            }
        }

        return isHappy;
    }
    private static int sumOfSquareDigits(int number) {
        int sum = 0;
        int input = number;
        while (input != 0) {
            int digit = input % 10;
            sum = sum + digit * digit;
            input = input / 10;
        }
        return sum;
    }
}
