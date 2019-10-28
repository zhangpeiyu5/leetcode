package difficulty.medium;

import java.util.ArrayList;
import java.util.List;

//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
public class Permute_46 {
    public static void main(String[] args) {
        Permute_46 test = new Permute_46();
        int[] nums = {1, 2, 3};
        System.out.println(test.permute1(nums));
    }

    /**
     * 方法一：回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
//        dfs1(nums, 0, res, new ArrayList<>());
        dfs2(nums, 0, visited, res, new ArrayList<>());
        return res;
    }


    /**
     * @param nums
     * @param index 第几个位置
     * @param res
     * @param list
     */
    public void dfs1(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs1(nums, index + 1, res, list);

                //状态重置
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * @param nums
     * @param index   第几个位置
     * @param visited 标记某个下标的元素是否访问过
     * @param res
     * @param list
     */
    public void dfs2(int[] nums, int index, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs2(nums, index + 1, visited, res, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    /**
     * 方法二：递归交换
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
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

        for (int j = index; j < nums.length; j++) {
            swap(nums, index, j);
            permuteCore(nums, index + 1, res);
            //状态重置
            swap(nums, index, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
