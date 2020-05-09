package leetcode.others;

/**
 * Created by HAOYUXING on 2020/4/23.
 */
public class Coin {

    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     *
     * 示例1:
     *
     *  输入: n = 5
     *  输出：2
     *  解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * 示例2:
     *
     *  输入: n = 10
     *  输出：4
     *  解释: 有四种方式可以凑成总金额:
     * 10=10
     * 10=5+5
     * 10=5+1+1+1+1+1
     * 10=1+1+1+1+1+1+1+1+1+1
     * 说明：
     *
     * 注意:
     *
     * 你可以假设：
     *
     * 0 <= n (总金额) <= 1000000
     *
     * 链接：https://leetcode-cn.com/problems/coin-lcci
     */


    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int mod = 1000000007;

        // 递推数组 , dp[i] 表示计算i分有几种表示法
        int[] dp = new int[n + 1];

        // base
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            // 遍历硬币，每种硬币取或不取
            for (int j = 1; j <= n; j++) {
                if (coins[i] == j) {    // 硬币等于金额
                    dp[j] += 1;
                } else if (coins[i] < j) {  // 硬币小于金额
                    dp[j] = (dp[j] + dp[j - coins[i]]) % mod;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Coin coin = new Coin();
        int result = coin.waysToChange(5);
        System.out.println(result);
    }
}
