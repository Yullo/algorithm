package leetcode;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution371 {

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     *
     * 示例 1:
     *
     * 输入: a = 1, b = 2
     * 输出: 3
     * 示例 2:
     *
     * 输入: a = -2, b = 3
     * 输出: 1
     *
     * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
     */


    // 异或 ^ 可以理解为无进位加法， & 可以获得进位 ， 进位左移相加，直至进位为0
    public int getSum(int a, int b) {
        while (b != 0) {
            int t = a ^ b;
            b = (a & b) << 1;
            a = t;
        }
        return a;
    }
}
