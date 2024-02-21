package lc201BitwiseAndOfRange;

public class Solution2 {
    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    /**
     * Intuition is that,
     * -- When we do BITWISE AND,
     * -- if the digits are flipped, it results in zero
     * -- If we flip a digit, all digits to the right are also flipped
     * -- The most significant digits that is equal in both numbers, doesn't change after the AND Operation
     * -- All the digits to the right of the MSD must be flipped in the numbers between them, thus they should be zero
     */
    private static int rangeBitwiseAnd(int left, int right) {
        int shiftBy = 0;
        while (left != right) {
            //Right shift (Remove the least significant digit) both numbers until they are equal
            left = left >> 1;
            right = right >> 1;
            shiftBy++;
        }
        //Left shift (Add a 0 after least significant digit) equal to the times the numbers where right shifted
        return left << shiftBy;
    }
}
