package leetcode;

import java.util.Arrays;

/**
 * Created by HAOYUXING on 2020/7/10.
 */
public class Solution287 {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 示例 1:
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     *
     * 说明：
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n ^ 2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
     */


    // 二分查找法  如果没有重复数，那么数组中小于等于mid的个数就是mid
    // 所以，如果小于等于mid的个数大于mid, 说明重复数在 1 - mid 之中 , 小于mid, 在 mid - n 之中
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long c = Arrays.stream(nums).filter(item -> item <= mid).count();
            if (c <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }


    // 快慢指针法， 这个题可以演化成环形链表找环的入口
    public int findDuplicateV2(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }

}
