package lc122BestTimeToBuyStockII;

public class Solution1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4,5,2,1,3,7};
        System.out.println(maxProfit(prices));
    }
/*
    The intuition here is that if we just keep adding the profits of consecutive days when,
    the price at previous day is lower than the price of current day, we can find out the max
    profit made.
 */
    private static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
