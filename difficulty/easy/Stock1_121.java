package difficulty.easy;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 * 只能交易一次
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
 * 结果：dp[i][k][0]
 */
public class Stock1_121 {
    public static void main(String[] args) {
        Stock1_121 test = new Stock1_121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(test.maxProfit1(prices));
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
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }

        return dp[n - 1][0];
    }


    /**
     * 动态规划（中间变量）
     * 因为本次状态之和上一个状态有关，用变量代替dp数组。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp_i_0 = 0;
                dp_i_1 = -prices[0];
            } else {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
        }
        return dp_i_0;
    }

}
