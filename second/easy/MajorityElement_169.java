package second.easy;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2

public class MajorityElement_169 {
    public static void main(String[] args) {
        MajorityElement_169 test = new MajorityElement_169();
        int[] nums = {10, 9, 9, 9, 10};
        System.out.println(test.majorityElement(nums));
    }

    /**
     * 如果我们把众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
     *
     * 先假设nums[0]为众数，数量为1，然后遍历数组，如果nums[i]不是众数，则num--,如果是则num++，如果抵消后数量小于0，说明众数发生变化，更新为nums[i],以此类推。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != majority) {
                num--;
            } else {
                num++;
            }
            if (num < 0) {
                majority = nums[i];
                num = 1;
            }
        }

        return majority;
    }
}

