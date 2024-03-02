package lc66PlusOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
    }

    private static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        for (int val : digits) {
            str.append(val);
        }
        StringBuffer reverse = str.reverse();
        int firstVal = Integer.parseInt(reverse.substring(0, 1)) + 1;
        list.add(firstVal % 10);
        int carry = firstVal / 10;

        for (int i = 1; i < reverse.length(); i++) {
            int current = Integer.parseInt(reverse.substring(i, i + 1)) + carry;
            list.add(current % 10);
            carry = current / 10;
        }
        if (carry != 0) {
            list.add(carry);
        }
        return list.reversed().stream().mapToInt(b -> b).toArray();
    }
}
