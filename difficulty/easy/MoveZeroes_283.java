package difficulty.easy;

import java.util.Arrays;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
public class MoveZeroes_283 {
    public static void main(String[] args) {
        MoveZeroes_283 test = new MoveZeroes_283();
        int[] nums = {1};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

