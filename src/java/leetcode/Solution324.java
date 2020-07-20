package leetcode;

import java.util.Arrays;

/**
 * Created by HAOYUXING on 2020/7/17.
 */
public class Solution324 {

    /**
     * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     *
     * 示例 1:
     *
     * 输入: nums = [1, 5, 1, 1, 6, 4]
     * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
     * 示例 2:
     *
     * 输入: nums = [1, 3, 2, 2, 3, 1]
     * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
     * 说明:
     * 你可以假设所有输入都会得到有效的结果。
     *
     * 进阶:
     * 你能用 O(n) 时间复杂度和/或原地 O(1) 额外空间来实现吗？
     *
     * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
     */

    // 时间复杂度 O(nlogn) ,空间复杂度 O(n)
    public void wiggleSort(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 前半段是小的
        int[] little = Arrays.copyOfRange(nums, 0, (nums.length + 1) / 2);
        // 后半段是大的
        int[] large = Arrays.copyOfRange(nums, (nums.length + 1) / 2, nums.length);
        // 穿插排列, 从尾到头， 可以避免重复元素相邻
        int l = little.length - 1;
        int g = large.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = little[l--];
            } else {
                nums[i] = large[g--];
            }
        }
    }

    /**
     * 时间复杂度O(n) 空间复杂度 O(1)
     * 先获取中位数, 复杂度要满足上面
     * 再使用三指针（荷兰国旗算法）
     * https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
     */
}
