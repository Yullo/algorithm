package leetcode;

/**
 * Created by HAOYUXING on 2020/7/17.
 */
public class Solution322 {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *  
     *
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     *
     * 链接：https://leetcode-cn.com/problems/coin-change
     */

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成金额i所需要的最小的硬币个数
        int[] dp = new int[amount + 1];
        // base
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 因为求最小值, 这里用最大值表示无解
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 如果下标有效，且不是无解
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    // 上轮的硬币个数 + 本次选择 ， 循环里选一个最小的
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 无解返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
