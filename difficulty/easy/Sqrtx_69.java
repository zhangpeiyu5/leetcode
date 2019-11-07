package difficulty.easy;

//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
public class Sqrtx_69 {
    public static void main(String[] args) {
        Sqrtx_69 test = new Sqrtx_69();
        int x = 1;
        System.out.println(test.mySqrt2(x));
    }

    /**
     * 方法一：暴力法遍历(超时)
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        for (int i = 0; i < x; i++) {
            if (i * i == x || (i * i < x && (i + 1) * (i + 1) > x)) {
                return i;
            }
        }
        return x;
    }


    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }


    /**
     * 方法三：牛顿法  ???
     *
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        return 0;
    }

}

