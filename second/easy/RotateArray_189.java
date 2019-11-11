package second.easy;

import java.util.Arrays;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
public class RotateArray_189 {
    public static void main(String[] args) {
        RotateArray_189 test = new RotateArray_189();
        int[] nums = {1, 2};
        int k = 0;
        test.rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一：定义辅助数组
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    /**
     * 方法二：反转子数组
     *
     * @param nums 6 7 1 2 3 4 5
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    public void rotate(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}

