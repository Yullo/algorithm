package leetcode;

/**
 * Created by HAOYUXING on 2020/7/20.
 */
public class Solution326 {

    /**
     *给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     *
     * 示例 1:
     *
     * 输入: 27
     * 输出: true
     * 示例 2:
     *
     * 输入: 0
     * 输出: false
     * 示例 3:
     *
     * 输入: 9
     * 输出: true
     * 示例 4:
     *
     * 输入: 45
     * 输出: false
     *
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     *
     * 链接：https://leetcode-cn.com/problems/power-of-three
     */

    // 循环
    public boolean isPowerOfThreeV2(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return true;
    }

    // 数学
    // 如果 3 ^ k = N 那么 k = log N / log 3; k 是整数
    public boolean isPowerOfThree(int n) {
        double v = Math.log10(n) / Math.log10(3);
        return v == (int) v;
    }
}
