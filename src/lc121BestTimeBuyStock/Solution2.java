package lc121BestTimeBuyStock;


import java.util.Arrays;

/**
 * TLE in Leetcode
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length > 2){
            for (int i = 0; i < prices.length - 1; i++) {
                int currProfit = getCurrentProfit(prices, i);
                profit = Math.max(currProfit, profit);
            }
        }
        return profit;
        }

    private static int getCurrentProfit(int[] prices, int currentIndex) {
        int arraySize = prices.length - currentIndex - 1;
        int[] restArray = new int[arraySize];
        System.arraycopy(prices, currentIndex + 1, restArray, 0, arraySize);
        Arrays.sort(restArray);
        return restArray[arraySize-1] - prices[currentIndex];
    }
}
