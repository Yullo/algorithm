package leetcode;

/**
 * Created by HAOYUXING on 2020/7/16.
 */
public class Solution300 {

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n ^ 2) 。
     *
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     */


    // 动态规划，时间复杂度 O(n ^ 2)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i]为结尾的序列，最长的上升子序列长度
        int[] dp = new int[nums.length];
        // base
        dp[0] = 1;

        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            // 最小的值就是它自身，为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 如果当前的数大于前面的， 则当前的结果为前面最大的某个位置 + 1
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 因为有可能后面的数是小的，所以最大值不是最后的数
            // 而是dp 数组中的最大值
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * 时间复制度 O (n log n) 的解法：
     *
     * 另外创建一个数组用以保存最长上升子序列 ， 一开始为空。
     * 遍历数组，如果该值大于子序列的末尾， 则将该值加入达到子序列之中
     * 如果该值小于子序列的开头，则替换子序列的开头为自己
     * 如果该值介于子序列开头和结尾之间， 使用二分查找法，找到子序列中第一个大于该值的数，将其替换为自己
     * 遍历完成后，可以得到最长上升子序列。 这个过程只遍历一遍数组, 二分查找子序列，时间复杂度 n log n
     */

}
