package difficulty.medium;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。

public class Rob2_213 {
    public static void main(String[] args) {
        Rob2_213 test = new Rob2_213();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.rob(nums));
    }

    /**
     * 动态规划（中间变量）
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int x1 = 0;    //i-2
        int y1 = 0;    //i-1
        int z1 = 0;    //i

        int x2 = 0;  //i-2
        int y2 = 0;  //i-1
        int z2 = 0;  //i


        for (int i = 0; i < nums.length - 1; i++) {
            //计算去掉最后一个节点
            z1 = Math.max(y1, x1 + nums[i]);
            x1 = y1;
            y1 = z1;

            //计算去掉第一个节点
            z2 = Math.max(y2, x2 + nums[i + 1]);
            x2 = y2;
            y2 = z2;
        }

        return Math.max(z1, z2);
    }
}
