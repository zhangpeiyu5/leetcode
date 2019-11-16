package difficulty.medium;
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TriangleMinimumTotal_120 {
    Integer[][] memo;

    public static void main(String[] args) {
        TriangleMinimumTotal_120 test = new TriangleMinimumTotal_120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(test.minimumTotal4(triangle));
    }

    /**
     * 方法一：递归 (超时)
     * 时间复杂度：O(2^n)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return recursive(0, 0, triangle);
    }

    //level是层数，c记录第level层的第c个元素
    public int recursive(int level, int c, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(c);
        }

        int left = recursive(level + 1, c, triangle);
        int right = recursive(level + 1, c + 1, triangle);

        return Math.min(left, right) + triangle.get(level).get(c);
    }


    /**
     * 方法二：递归+记忆化搜索 （AC）
     * <p>
     * 使用memo数组记录下中间结果。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return recursive2(0, 0, triangle);
    }

    public int recursive2(int level, int c, List<List<Integer>> triangle) {
        if (memo[level][c] != null) {
            return memo[level][c];
        }
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(c);
        }

        int left = recursive2(level + 1, c, triangle);
        int right = recursive2(level + 1, c + 1, triangle);

        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }

    /**
     * 方法三：动态规划 (dp为二维数组)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];    //加1可以不用初始化最后一行
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + temp.get(j);
            }
        }
        return dp[0][0];
    }


    /**
     * 方法四：动态规划 （dp为一维数组）
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + temp.get(j);
            }
        }
        return dp[0];
    }
}
