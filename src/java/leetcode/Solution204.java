package leetcode;

/**
 * Created by HAOYUXING on 2020/6/28.
 */
public class Solution204 {

    /**
     *统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     *
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     * 链接：https://leetcode-cn.com/problems/count-primes
     */

    public int countPrimes(int n) {
        int[] nums = new int[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 0) {
                res++;
            }
            // 这个数的倍数都不是质数
            for (int j = 2 * i; j < n; j += i) {
                nums[j] = 1;
            }
        }
        return res;
    }
}
