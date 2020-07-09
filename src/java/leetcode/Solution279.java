package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/7/9.
 */
public class Solution279 {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     */

    public int numSquares(int n) {
        // 表示和为n的最少个数
        int[] dp = new int[n + 1];  // 0 - n 共 n + 1 个数
        // base
        dp[0] = 0;
        dp[1] = 1;

        // 可选择数
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) {
                break;
            }
            list.add(i * i);
        }

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 遍历选择，找到最小值 , 这里从大到小遍历速度会快很多
            for (Integer value : list) {
                if (i >= value) {
                    min = Math.min(min, dp[i - value]);
                }
            }
            // 加上当前选择
            dp[i] = min + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(solution279.numSquares(13));
    }
}
