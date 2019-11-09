package difficulty.hard;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
public class trappingRainWater_42 {
    public static void main(String[] args) {
        trappingRainWater_42 test = new trappingRainWater_42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(test.trap3(height));
    }

    /**
     * 方法一：暴力法
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        return 0;
    }

    /**
     * 方法三：暴力法优化
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        return 0;
    }

    /**
     * 方法三：双指针法
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return res;
        }
        int len = height.length;
        int lmax = height[0];
        int rmax = height[len - 1];
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            if (lmax < rmax) {
                if (height[l] >= lmax) {
                    lmax = height[l];
                } else {
                    res += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    res += rmax - height[r];
                }
                r--;
            }
        }
        return res;
    }
}
