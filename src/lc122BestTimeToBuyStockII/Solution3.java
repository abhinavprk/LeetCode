package lc122BestTimeToBuyStockII;

public class Solution3 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 5, 2, 1, 3, 7};
        System.out.println(maxProfit(prices));
    }

    /*If we analyze the graph, we notice that the points of interest are the consecutive valleys and peaks.
        The key point is we need to consider every peak immediately following a valley to maximize the profit.
        In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over
        one of the transactions leading to an overall lesser profit. */
    private static int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while ((i < prices.length - 1) && (prices[i] >= prices[i + 1])) {
                i++;
            }
            valley = prices[i];
            while ((i < prices.length - 1) && (prices[i] <= prices[i + 1])) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
