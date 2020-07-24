package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/4/23.
 */
public class Solution1 {

    /**
     * 1. 两数之和
     *
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *  
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 链接：https://leetcode-cn.com/problems/two-sum
     *
     * TAG: 哈希表
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            Integer idx = map.get(other);
            if (idx != null) {
                return new int[]{i, idx};
            } else {
                map.put(nums[i], i);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] ints = s.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}

