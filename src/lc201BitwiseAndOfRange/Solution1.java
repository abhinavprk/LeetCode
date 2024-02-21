package lc201BitwiseAndOfRange;

public class Solution1 {
    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int and = left;
        while(left < right){
            and = and ^ left+1;
            left++;
        }
        return and;
    }
}
