package lc152MaxProduct;

public class Solution1 {

    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{0,2}));
        System.out.println(maxProduct(new int[]{-3,0,1,-2}));
    }

    private static int maxProduct(int[] nums) {
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            maxProduct = Math.max(product, maxProduct);
            for (int j = i + 1; j < nums.length; j++) {
                product = product * nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
            product = 1;
        }

        return maxProduct;
    }
}
