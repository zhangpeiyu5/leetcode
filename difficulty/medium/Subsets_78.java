package difficulty.medium;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        Subsets_78 test = new Subsets_78();
        int[] nums = {1, 2, 3};
        System.out.println(test.subsets2(nums));
    }

    /**
     * 方法一：递归
     * <p>
     * 对应1，2，3,每次都有选或不选两种选择，回到上一层时，应该把这一层最后加入的元素去除。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums, 0, lists, new ArrayList<>());
        return lists;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subSet) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subSet));
            return;
        }

        dfs(nums, index + 1, res, subSet);

        subSet.add(nums[index]);
        dfs(nums, index + 1, res, subSet);


        subSet.remove(subSet.size() - 1);
    }


    /**
     * 方法二：迭代法
     * 分别添加1，2，3,遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     * [[]]  ->[] [1] ->[][1][2][1,2] ->[][1][2][1,2][3][1,3][2,3][1,2,3]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int currentSize = res.size();
            for (int j = 0; j < currentSize; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

}

