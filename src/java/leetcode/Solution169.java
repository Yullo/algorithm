package leetcode;

import java.util.Arrays;

/**
 * Created by HAOYUXING on 2020/6/24.
 */
public class Solution169 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * 链接：https://leetcode-cn.com/problems/majority-element
     */

    // 相同的数计数，不同的数减去，时间复杂度 O(n)
    public int majorityElement(int[] nums) {
        int t = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (t == 0) {
                temp = num;
            }
            if (num == temp) {
                t++;
            } else {
                t--;
            }
        }
        return temp;
    }

    public int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
