package leetcode;

/**
 * Created by HAOYUXING on 2020/6/24.
 */
public class Solution172 {

    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     *
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     *
     * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
     */

    // 只有 2 * 5 会导致结尾有0 ， 因为2的个数多于5， 所以结果取决于5的个数
    // 当n = 25时, 有5个5 ，（5，10，15，20，25）， 但是 25 = 5 * 5, 相当于有2个5， 多了一个5，所以需要再加1， 故 25 的结果是 6
    // 归纳起来，结果就是 5 的个数 + 25 的个数 + 5 的 k 次 的个数
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}
