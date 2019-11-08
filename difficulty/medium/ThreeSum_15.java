package difficulty.medium;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，  -4 -1 -1 0 1 2
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        ThreeSum_15 test = new ThreeSum_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;     //去重
            }
            twoSum(nums, i, 0 - nums[i], res);
        }
        return res;
    }

    //双指针寻找两数之和为0的组合
    public void twoSum(int[] nums, int index, int target, List<List<Integer>> res) {
        int L = index + 1;
        int R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] == target) {
                res.add(Arrays.asList(nums[index], nums[L], nums[R]));
                while (L < R && nums[L] == nums[L + 1]) {
                    L++;    //去重
                }
                while (L < R && nums[R] == nums[R - 1]) {
                    R--;     //去重
                }
                L++;
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                R--;
            }
        }
    }
}
