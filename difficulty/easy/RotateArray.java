package easy;

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
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一：暴力法
     * 每次循环数组中元素向右移动一位，移动k次。
     * 如：[1,2,3,4,5,6,7] 和 k = 3
     * /向右旋转 1 步: [7,1,2,3,4,5,6]
     * //向右旋转 2 步: [6,7,1,2,3,4,5]
     * //向右旋转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 时间复杂度：O（n*k）
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];     //最后一个元素和每个元素交换位置实现一位移动。
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 方法二：使用额外的数组
     * 使用 temp[(i + k) % nums.length] = nums[i] 操作原数组时，会发生数据覆盖，可以考虑新建一个数组来保存该操作之后的数据，然后复制给原来的数组。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * 方法三：使用反转：
     * 将[1,2,3,4,5,6,7] 前nums.length-k个 的元素进行反转得[4,3,2,1]，后k个元素进行反转得[7,6,5]，合并两个数组[4,3,2,1,7,6,5],
     * 反转合并后的数据：[5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, nums.length - k , nums.length - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, nums.length - 1);
    }

    //采用首位交换元素的方式反转数组。
    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (end > start) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
