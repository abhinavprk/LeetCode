package lc231PowerOfTwo;

public class Solution1WithLoops {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(20));
    }

    private static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}
