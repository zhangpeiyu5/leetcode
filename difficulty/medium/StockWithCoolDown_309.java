package difficulty.medium;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
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
public class StockWithCoolDown_309 {
    public static void main(String[] args) {
        StockWithCoolDown_309 test = new StockWithCoolDown_309();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(test.maxProfit2(prices));
    }

    /**
     * 动态规划（dp数组）
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            } else if (i == 1) {
                dp[i][0] = Math.max(0, prices[1] - prices[0]);
                dp[i][1] = Math.max(-prices[0], -prices[1]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }

        }

        return dp[n - 1][0];
    }

    /**
     * 动态规划（变量）
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0;   //dp[i-1][0]
        int dp_i_1 = -prices[0];   //dp[i-1][1]
        int dp_i2_0 = 0;   //dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i2_0 - prices[i]);
            dp_i2_0 = temp;
        }

        return dp_i_0;
    }
}
