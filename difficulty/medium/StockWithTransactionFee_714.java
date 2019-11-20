package difficulty.medium;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 交易次数最多k次
 * <p>
 * <p>
 * dp[i][k][s]  表示第i天，最多交易k次，状态为持有1/不持有0时的最大收益。
 * <p>
 * 递推公式：
 * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
 * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
 * (买入股票减去prices[i]，卖出股票加prices[i])
 * <p>
 * 初始条件：
 * dp[0][0][0]=0
 * dp[0][0][1] 不可能发生
 * dp[-1][0][0]=0
 * dp[-1][0][1] 不可能发生
 * <p>
 * <p>
 */

public class StockWithTransactionFee_714 {
    public static void main(String[] args) {
        StockWithTransactionFee_714 test = new StockWithTransactionFee_714();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(test.maxProfit2(prices, fee));
    }

    /**
     * 动态规划（dp数组）
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);   //卖出时收取手续费
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划（变量）
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
