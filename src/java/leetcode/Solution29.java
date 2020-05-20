package leetcode;

/**
 * Created by HAOYUXING on 2020/5/19.
 */
public class Solution29 {

    /**
     *给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *
     *  
     *
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *  
     *
     * 提示：
     *
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2 ^ 31,  2 ^ 31 − 1]。本题中，如果除法结果溢出，则返回 2 ^ 31 − 1。
     *
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     */

    // 递减法，会超时
    public int divide(int dividend, int divisor) {
        int i = 0;
        boolean neg = (dividend ^ divisor) < 0;
        //未判断边界
        int dd = Math.abs(dividend);
        int ds = Math.abs(divisor);
        while (dd - ds >= 0) {
            dd -= ds;
            i++;
        }
        return neg ? 0 - i : i;
    }

    /**
     * 要计算 a 除以 b，则可以根据除法定义，寻找到 a 中包含了多少个 b . (上面的方法)
     * 但是这样数太慢了， 可以一次性加上n个除数，
     * 前提是需要知道这n个除数之和，这个可以从前面的结果直接得到：比如上一步累加完之后，统计一共累加了 m 个 b 了，那么下一次可以直接在 sum 上累加 m 个 b，因为这 m 个 b 的值已经知道了。同理，下一次累加时，就知道了 2m 个 b 的累加值了，就可以直接累加 2m 个 b。
     * 假设下一步sum超过了a， 说明结果就是 2m 个 b 再加上 （a-2m） 中 b 的个数 。
     */
    public int divideV2(int dividend, int divisor) {
        // 只有在这种情况会超过边界，特殊处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 判断结果正负
        boolean neg = (dividend ^ divisor) < 0;

        // 因为负数的范围比正数大，所以转换成负数计算
        int dd = dividend > 0 ? 0 - dividend : dividend;
        int ds = divisor > 0 ? 0 - divisor : divisor;

        // 这里是负数，说明不够一个除数，返回0
        if (dd > ds) {
            return 0;
        }

        // 计算的轮次
        int i = 0;
        // 除数的个数
        int count = 0;

        // 上一轮的除数，若下一轮计算的除数超过范围，说明这个值是临界点，需要找剩下的数中除数的个数
        int lastds = 0;
        // 中间变量，表示下一轮的除数
        int tp = ds;
        while (dd - tp <= 0) {
            // 除数的个数 ， 与第几轮计算有关，因为除数倍增，所以这里依次是 1，2，4，8，16
            count = 1 << (i++);

            lastds = tp;

            // 下一轮计算会超过范围，提前结束
            if (tp + tp >= 0) {
                break;
            }
            tp = tp + tp;
        }
        count += divideV2(dd - lastds, ds);
        return neg ? 0 - count : count;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        System.out.println(solution29.divideV2(Integer.MIN_VALUE, 1));
    }

}
