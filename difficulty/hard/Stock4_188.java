package difficulty.hard;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
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

public class Stock4_188 {
    public static void main(String[] args) {
        Stock4_188 test = new Stock4_188();
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(test.maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k >= n / 2) {
            //如果k>=n/2，演变为没有交易次数限制的情况
            return maxProfitWithIndefiniteTimes(prices);
        } else {
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i - 1 == -1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[0];

                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
            return dp[n - 1][k][0];
        }
    }

    public int maxProfitWithIndefiniteTimes(int[] prices) {
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
                dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
            }
        }
        return dp_i_0;
    }

}
