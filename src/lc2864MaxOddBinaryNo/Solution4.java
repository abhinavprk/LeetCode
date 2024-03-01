package lc2864MaxOddBinaryNo;

public class Solution4 {

    public static void main(String[] args) {
        String num = "00111";

        System.out.println(maximumOddBinaryNumber(num));
    }

    private static String maximumOddBinaryNumber(String s) {
        int count1 = 0;
        int count0 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                count1++;
            } else {
                count0++;
            }
        }
        StringBuilder result = new StringBuilder();
        while(count1 > 1){
            result.append('1');
            count1--;
        }
        while(count0 > 0){
            result.append('0');
            count0--;
        }
        result.append('1');
        return result.toString();
    }
}
