package difficulty.medium;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
// 说明:
//你可以认为每种硬币的数量是无限的。

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange_322 {
    public static void main(String[] args) {
        CoinChange_322 test = new CoinChange_322();
        int[] coins = {1, 2, 5};
        int amount = 100;
        System.out.println(test.coinChange1(coins, amount));
    }

    /**
     * 方法一：动态规划
     * f(n)=Min(f(n-1)+1,f(n-2)+1,f(n-5)+1)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 方法二：BFS（超时）
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        int step = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                Integer temp = queue.poll();
                for (int i = 0; i < coins.length; i++) {
                    if (temp > coins[i]) {
                        queue.add(temp - coins[i]);
                    }
                    if (temp == coins[i]) {
                        return step + 1;
                    }
                }
                levelSize--;
            }
            step++;
        }
        return -1;
    }

}
