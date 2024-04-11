package lc2485PivotInteger;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(3));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    private static int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int leftSum = 0;
        int rightSum = 0;
        boolean sumLeft = true;
        boolean sumRight = true;
        while ((left <= right)) {
            if (sumLeft) {
                leftSum += left;
                sumLeft = false;
            }
            if (sumRight) {
                rightSum += right;
                sumRight = false;
            }
            if (leftSum < rightSum) {
                left++;
                sumLeft = true;
            } else if (leftSum > rightSum) {
                right--;
                sumRight = true;
            } else if (left != right) {
                left++;
                sumLeft = true;
                right--;
                sumRight = true;
            } else {
                break;
            }
        }
        System.out.println("left:" + left);
        System.out.println("right:" + right);
        System.out.println("leftSum:" + leftSum);
        System.out.println("rightSum:" + rightSum);
        int result;
        if ((leftSum == rightSum) && (left == right)) {
            result = left;
        } else {
            result = -1;
        }
        return result;

    }
}
