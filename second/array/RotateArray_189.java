package second.array;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。


public class RotateArray_189 {
    public static void main(String[] args) {
        RotateArray_189 test = new RotateArray_189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        test.rotate1(nums, k);
    }


    /**
     * 方法一：使用辅助数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //定义中间数组，生成移动后的结构
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        //赋值给原始数组
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }


    /**
     * 方法二：反转数组
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }


    public void reverse(int[] nums, int start, int end) {
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
