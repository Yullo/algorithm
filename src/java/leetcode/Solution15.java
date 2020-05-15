package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/5/14.
 */
public class Solution15 {

    /**
     * 15. 三数之和
     *
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/3sum
     */

    // 这个方法会超时
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            map.put(num1, i);
            for (int j = i + 1; j < nums.length; j++) {
                Integer thirdIdx = map.get(-1 * num1 - nums[j]);
                if (thirdIdx != null && thirdIdx != j && thirdIdx != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(num1);
                    temp.add(-1 * num1 - nums[j]);
                    temp.add(nums[j]);
                    temp.sort(Comparator.naturalOrder());
                    if (!res.contains(temp)) {
                        res.add(temp);
                    }
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return res;
    }

    // 先排序 再用双指针
    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            // 排序后一开始是正数，跳过
            if (num1 > 0) {
                break;
            }
            // 如果判断的数字之前出现过，说明重复
            if (i > 0 && num1 == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (num1 + nums[l] + nums[r] < 0 || (l > i + 1 && nums[l] == nums[l - 1])) {
                    l++;
                } else if (num1 + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(num1);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                }

            }
        }
        return res;
    }

}
