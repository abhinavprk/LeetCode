package lc8StringToInteger;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("with words 4193 "));
        System.out.println(myAtoi("+-1"));
        System.out.println(myAtoi("-+1"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("-1"));
        System.out.println(myAtoi("-+a"));
        System.out.println(myAtoi("-a"));
        System.out.println(myAtoi("+a"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-+"));
        System.out.println(myAtoi("+-"));
    }
    private static int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        boolean negative = false;
        int count = 0;

        for (char val : s.trim().toCharArray()) {
            if (result.isEmpty()) {
                if ((s.length() > 1) && (count == 0) && (val == '-')) {
                    negative = true;
                } else if (((int) val > 48) && ((int) val < 58)) {
                    result.append(val);
                } else if ((negative && (val == '+')) || (!negative && (count > 0) && (val == '+'))
                        || (!(val == '+') && ((int) val < 48) || ((int) val > 58))) {
                    break;
                }
            } else if (((int) val > 47) && ((int) val < 58)) {
                result.append(val);
            } else {
                break;
            }
            count++;
        }
        if (negative && !result.isEmpty()) {
            result.insert(0, '-');
        }
        if (result.isEmpty()) {
            result.append('0');
        }
        int resVal;
        try {
            resVal = Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            if (negative) {
                resVal = Integer.MIN_VALUE;
            } else {
                resVal = Integer.MAX_VALUE;
            }
        }
        return resVal;
    }
}
