package second.backtrace;

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
public class Permutation_46 {
    public static void main(String[] args) {
        Permutation_46 test = new Permutation_46();
        int[] nums = {1, 2, 3};
        System.out.println(test.permute(nums));
    }

    /**
     * 方法一：回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(0, nums, visited, res, new ArrayList<>());

        return res;
    }

    public void dfs(int index, int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> list) {
        //terminator
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                //process current level
                list.add(nums[i]);
                visited[i] = true;

                //next level
                dfs(index + 1, nums, visited, res, list);

                //重置
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

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteCore(nums, index + 1, res);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
