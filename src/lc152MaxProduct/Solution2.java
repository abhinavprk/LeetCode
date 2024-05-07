package lc152MaxProduct;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{-3, 0, 1, -2}));

    }

    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1, suff = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) {
                pre = 1;
            }
            if (suff == 0) {
                suff = 1;
            }
            pre *= nums[i];
            suff *= nums[n - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(pre, suff));
        }
        return maxProduct;
    }
}
