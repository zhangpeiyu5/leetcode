package difficulty.easy;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// 斐波拉切数列
public class ClimbStairs_70 {
    public static void main(String[] args) {
        ClimbStairs_70 test = new ClimbStairs_70();
        int n = 3;
        System.out.println(test.climbStairs3(n));
    }

    /**
     * 方法一：递归法  f(n)=f(n-1)+f(n-2)  （超时）
     * 缺点：对中间数据没有记录，重复计算
     * <p>
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


    /**
     * 方法二：动态递推（对中间结果进行记录）
     * 采用辅助数组，自底向上。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }


    /**
     * 方法三：动态递推  (对中间结果进行记录）再优化
     * 用变量代替数组
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 2; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
}
