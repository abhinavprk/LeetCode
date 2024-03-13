package lc2485PivotInteger;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(pivotInteger(1000));
        System.out.println(pivotInteger(3));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    private static int pivotInteger(int n) {
        // Initialize left and right pointers for binary search
        int left = 1, right = n;

        // Calculate the total sum of the sequence
        int totalSum = n * (n + 1) / 2;

        // Binary search for the pivot point
        while (left < right) {
            // Calculate the mid-point
            int mid = (left + right) / 2;

            // Check if the difference between the square of mid and the total sum is negative
            if (mid * mid - totalSum < 0) {
                left = mid + 1; // Adjust the left bound if the sum is smaller
            } else {
                right = mid; // Adjust the right bound if the sum is equal or greater
            }
        }

        // Check if the square of the left pointer minus the total sum is zero
        if (left * left - totalSum == 0) {
            return left;
        } else {
            return -1;
        }

    }
}
