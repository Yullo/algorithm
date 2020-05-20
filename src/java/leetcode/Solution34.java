package leetcode;

import java.util.Arrays;

/**
 * Created by HAOYUXING on 2020/5/20.
 */
public class Solution34 {

    /**
     *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     *
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return search(m, nums);
            }
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return new int[]{-1, -1};
    }

    //找到值后两边扩散
    private int[] search(int m, int[] nums) {
        int r = m;
        for (; r < nums.length - 1; r++) {
            if (nums[r] != nums[r + 1]) {
                break;
            }
        }
        int l = m;
        for (; l > 0; l--) {
            if (nums[l] != nums[l - 1]) {
                break;
            }
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        System.out.println(Arrays.toString(solution34.searchRange(new int[]{2, 2}, 2)));
    }
}
