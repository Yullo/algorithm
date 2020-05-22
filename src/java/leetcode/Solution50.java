package leetcode;

/**
 * Created by HAOYUXING on 2020/5/22.
 */
public class Solution50 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2 ^ -2 = 1/2 ^ 2 = 1/4 = 0.25
     * 说明:
     *
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−2 ^ 31, 2 ^ 31 − 1] 。
     *
     * 链接：https://leetcode-cn.com/problems/powx-n
     */

    // n ^ x ==  (x ^ n /2) * (x ^ n /2)  画图好理解
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            // n 为负数时， 为倒数的 -n 次方 .  n 为最小值时，正数会超范围，特殊处理
            return n == Integer.MIN_VALUE ? 1 / x * myPow(1 / x, -(n + 1)) : myPow(1 / x, -n);
        }
        double v = myPow(x, n >> 1);
        // n 为奇数需要多乘一次
        return n % 2 == 1 ? x * v * v : v * v;
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.myPow(2.0, -2));
    }
}
