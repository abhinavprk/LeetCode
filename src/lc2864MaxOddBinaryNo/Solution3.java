package lc2864MaxOddBinaryNo;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        String num = "00111";

        System.out.println(maximumOddBinaryNumber(num));
    }

    private static String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 2;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        StringBuilder result = new StringBuilder();
        for(char val: arr){
            result.append(val);
        }
        return result.toString();
    }
}
