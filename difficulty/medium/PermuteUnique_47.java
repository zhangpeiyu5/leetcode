package difficulty.medium;
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
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique_47 {
    public static void main(String[] args) {
        PermuteUnique_47 test = new PermuteUnique_47();
        int[] nums = {1, 2, 1};
        System.out.println(test.permuteUnique2(nums));
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }


    /**
     * 方法一：递归交换剪枝
     *
     * @param nums
     * @param index
     * @param res
     */
    public void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }

        for (int j = index; j < nums.length; j++) {
            if (canSwap(nums, index, j)) {     //回溯法剪枝：在交换前判断能不能交换，去掉重复的部分。如果在nums[index]到nums[j-1]之间存在与nums[j]相同的值，则不必交换，会产生重复子分支。
                swap(nums, index, j);
                dfs(nums, index + 1, res);
                swap(nums, index, j);
            }
        }
    }

    public boolean canSwap(int[] nums, int index, int j) {
        for (int i = index; i < j; i++) {
            if (nums[i] == nums[j]) {
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


    /**
     * 方法二：回溯法剪枝
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);   //先排序
        dfs2(nums, 0, visited, res, new ArrayList<>());
        return res;
    }

    public void dfs2(int[] nums, int index, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                //因为排序以后重复的数一定不会出现在开始，故 i > 0
                //和之前同一层的数相等，并且之前同一层的数还未使用过，只有出现这种情况，才会出现相同分支
                //这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                dfs2(nums, index + 1, visited, res, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


}
