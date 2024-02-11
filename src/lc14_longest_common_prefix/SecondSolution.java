package lc14_longest_common_prefix;

import java.util.Arrays;

public class SecondSolution {
    public static void main(String[] args) {
        String [] strings = new String[]{"flower","flow","flight"};
        System.out.println(getLongestCommonPrefix(strings));
    }

    private static String getLongestCommonPrefix(String[] strings) {

        String[] input = Arrays.copyOf(strings, strings.length);
        Arrays.sort(input);
        int i = 0;
        String firstString = input[0];
        String lastString = input[input.length-1];
        while(i < firstString.length()){
            if(firstString.charAt(i) != lastString.charAt(i)){
                break;
            }
            i++;
        }
        return firstString.substring(0, i);
    }
}
