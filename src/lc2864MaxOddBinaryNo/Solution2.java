package lc2864MaxOddBinaryNo;

public class Solution2 {

    public static void main(String[] args) {
        String num = "00111";

        System.out.println(maximumOddBinaryNumber(num));
    }

    private static String maximumOddBinaryNumber(String s) {
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                count1++;
            }
        }
        StringBuilder result = new StringBuilder();
        if(count1>1) {
            int append1Count = count1 - 1;
            while(append1Count > 0){
                result.append("1");
                append1Count--;
            }
        }
        int zerosToAppend = s.length() - result.toString().length() - 1;
        while(zerosToAppend >0){
            result.append('0');
            zerosToAppend--;
        }
        result.append('1');

        return result.toString();
    }
}
