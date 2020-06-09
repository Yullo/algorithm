package leetcode;

/**
 * Created by HAOYUXING on 2020/6/9.
 */
public class Solution121 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     */

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // dp[i][0 or 1] 表示第i天，持有(1)或未持有(0)时的最大利润。
        int[][] dp = new int[prices.length][2];
        // base
        dp[0][0] = 0;             // 第一天未持有，利润为0
        dp[0][1] = -prices[0];    // 第一天持有， 说明买了，利润为负

        for (int i = 1; i < prices.length; i++) {
            // 第i天未持有 ， 说明 前一天也未持有，或者前一天持有，今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有，说明 前一天也持有，或者前一天未持有，今天买了。 只允许一次，今天买了，说明今天第一次交易，以前的利润是0
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        // 最后一天未持有，利润必然比持有高
        return dp[prices.length - 1][0];
    }

    /**
     * 解析:
     * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
     *
     *
     * 框架：
     *
     * for 状态1 in 状态1的所有取值：
     *     for 状态2 in 状态2的所有取值：
     *         for ...
     *             dp[状态1][状态2][...] = 择优(选择1，选择2...)
     *
     *
     */
}
