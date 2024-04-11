package lc2485PivotInteger;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(3));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    private static int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int leftSum = 1;
        int rightSum = n;
        int result =-1;
        if(n==1){
            result = 1;
        }
        while(left<right) {
            if (leftSum < rightSum) {
                leftSum = leftSum + ++left;
            } else {
                rightSum = rightSum + --right;
            }

            if ((leftSum == rightSum) && (left + 1 == right - 1)) {
                result = left + 1;
                break;
            }
        }
        return result;

    }
}
