package lc1492TheKthFactorOfN;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(kthFactor(12,3));
        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
    }

    private static int kthFactor(int n, int k) {
        int currentFactor = 1;
        while ((k > 0) && (currentFactor <= n)) {
            if (n % currentFactor == 0) {
                k--;
            }
            if (k != 0) {
                currentFactor++;
            }
        }
        if (k > 0) {
            return -1;
        } else {
            return currentFactor;
        }
    }
}
