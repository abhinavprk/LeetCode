package lc122BestTimeToBuyStockII;


/**
 * TLE in leetcode
 */
public class Solution2 {
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
        return calculate(prices, 0);
    }

    private static int calculate(int[] prices, int buyDay) {
        if (buyDay >= prices.length)
            return 0;
        int max = 0;
        for (int buy = buyDay; buy < prices.length; buy++) {
            int maxprofit = 0;
            for (int sell = buy + 1; sell < prices.length; sell++) {
                if (prices[buy] < prices[sell]) {
                    int profit = calculate(prices, sell) + prices[sell] - prices[buy];
                    maxprofit = Math.max(profit, maxprofit);
                }
            }
            max = Math.max(max,maxprofit);
        }
        return max;
    }
}
