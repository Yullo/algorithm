package leetcode;

/**
 * Created by HAOYUXING on 2020/6/22.
 */
public class Solution152 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     *
     * 相似题目： 53
     */


    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        // 子数组左端点
        for (int i = 0; i < nums.length; i++) {
            int t = 1;
            // 子数组右端点
            for (int j = i; j < nums.length; j++) {
                t *= nums[j];
                // 右端点右移时，逐个判断
                res = Math.max(res, t);
            }
        }

        return res;
    }

    public int maxProductV2(int[] nums) {
        // dp[i] 表示字串以第i个元素作为结尾时的最大值
        // 则： 这个序列只有一个元素，即以 nums[i] 开始，以 nums[i] 结尾
        // 或者 这个序列有多个元素，即从前面某处开始，一直到 nums[i] 结尾, 那么就是 dp[i-1] * nums[i]
        int dp[] = new int[nums.length];
        // 和连续最大和不一样，因为有可能是负数，负负为正，所以局部最优解不是全部最优解，还需要保存一个最小值，
        // 如果最小值是负数，最小值乘上一个负数就变成了一个正数
        int min[] = new int[nums.length];
        // base
        dp[0] = min[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(Math.min(nums[i], dp[i - 1] * nums[i]), min[i - 1] * nums[i]);
            dp[i] = Math.max(Math.max(nums[i], dp[i - 1] * nums[i]), min[i - 1] * nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
