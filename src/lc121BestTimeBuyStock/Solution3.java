package lc121BestTimeBuyStock;


import java.util.Arrays;

/**
 * TLE in Leetcode
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        int minVal = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int val = prices[i];
                if(val > minVal) {
                    int currProfit = val - minVal;
                    profit = Math.max(profit, currProfit);
                }
                minVal = Math.min(val, minVal);
            }
        return profit;
        }


}
