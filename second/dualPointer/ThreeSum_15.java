package second.dualPointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]， -4 -1 -1 0 1 2
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

public class ThreeSum_15 {
    public static void main(String[] args) {
        ThreeSum_15 test = new ThreeSum_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //升序排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //nums[i]>0时，不可能a + b + c = 0,
            if (nums[i] > 0) {
                break;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //求两数和为0 - nums[i]的组合
            twoSum(nums, i, 0 - nums[i], res);
        }
        return res;
    }


    public void twoSum(int[] nums, int index, int target, List<List<Integer>> res) {
        int L = index + 1;
        int R = nums.length - 1;

        while (L < R) {
            if (nums[L] + nums[R] == target) {
                res.add(Arrays.asList(nums[index], nums[L], nums[R]));
                while (L < R && nums[L + 1] == nums[L]) {
                    L++;   //去重
                }

                while (L < R && nums[R - 1] == nums[R]) {
                    R--;   //去重
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
