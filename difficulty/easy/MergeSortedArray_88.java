package difficulty.easy;

import java.util.Arrays;

//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
public class MergeSortedArray_88 {
    public static void main(String[] args) {
        MergeSortedArray_88 test = new MergeSortedArray_88();
        int[] nums1 = {2, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = nums1.length - nums2.length;
        int n = nums2.length;
        test.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 双指针法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = n + m - 1;
        while (i >= 0 && j >= 0) {
            nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
