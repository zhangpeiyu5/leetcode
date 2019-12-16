package second.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class PermutationII_47 {
    public static void main(String[] args) {
        PermutationII_47 test = new PermutationII_47();
        int[] nums = {1, 2, 1};
        System.out.println(test.permuteUnique2(nums));
    }

    /**
     * 方法一：回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);  //排序
        dfs(0, nums, visited, res, new ArrayList<>());
        return res;
    }

    public void dfs(int index, int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            ///因为排序以后重复的数一定不会出现在开始，故 i > 0
            //和之前同一层的数相等，并且之前同一层的数还未使用过，只有出现这种情况，才会出现相同分支
            //这种情况跳过即可
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;

                dfs(index + 1, nums, visited, res, list);

                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 递归交换法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteCore(nums, 0, res);
        return res;
    }

    public void permuteCore(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (canSwap(nums, index, i)) {  ////回溯法剪枝：在交换前判断能不能交换，去掉重复的部分。如果在nums[index]到nums[j-1]之间存在与nums[j]相同的值，则不必交换，会产生重复子分支。
                //交换index和i位置的元素
                swap(nums, index, i);
                //求index之后元素的全排列
                permuteCore(nums, index + 1, res);
                //重置
                swap(nums, index, i);
            }
        }
    }

    public boolean canSwap(int[] nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (nums[k] == nums[j]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
