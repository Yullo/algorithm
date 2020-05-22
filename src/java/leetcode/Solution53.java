package leetcode;

/**
 * Created by HAOYUXING on 2020/5/22.
 */
public class Solution53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     */

    // 复杂度 O(n ^ 2)
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) { // 左端点
            int t = 0;
            for (int j = i; j < nums.length; j++) { // 右端点
                t += nums[j];
                res = Math.max(res, t);  // 右端点右移时，逐个判断
            }
        }
        return res;
    }


    // 复杂度 O(n) 动态规划  空间复杂度 O(n)
    // dp[i] 表示以 nums[i] 作为末尾的连续序列的最大和（这里是说 nums[i] 必须作为连续序列的末尾）
    // 则： 这个最大和的连续序列只有一个元素，即以 nums[i] 开始，以 nums[i] 结尾
    // 或者 这个最大和的连续序列有多个元素，即从前面某处开始，一直到 nums[i] 结尾, 那么就是 dp[i-1] + nums[i]
    public int maxSubArrayV2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    // 复杂度 O(n) 动态规划  空间复杂度 O(1)
    // dp 只与上个数有关，用一个变量代替
    public int maxSubArrayV3(int[] nums) {
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArrayV2(new int[]{-1, -2}));
    }
}
