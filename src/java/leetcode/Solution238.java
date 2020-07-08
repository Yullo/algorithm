package leetcode;

/**
 * Created by HAOYUXING on 2020/7/8.
 */
public class Solution238 {

    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     *  
     *
     * 示例:
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *  
     *
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     *
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     */

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        // 从头到尾遍历，计算元素左边的累乘
        for (int j = 1; j < nums.length; j++) {
            left[j] = left[j - 1] * nums[j - 1];
        }
        int right = 1;

        // 从尾到头遍历，计算元素右边的累乘
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            // 使用左边的数组存储结果
            left[i] = left[i] * right;
        }
        return left;
    }

}
