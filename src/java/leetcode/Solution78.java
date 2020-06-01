package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/6/1.
 */
public class Solution78 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/subsets
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        work(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void work(int idx, int[] nums, List<Integer> list, List<List<Integer>> res) {
        // 所有元素均考虑过了
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 不选择该元素，直接跳到下一层
        work(idx + 1, nums, list, res);

        // 选择该元素
        Integer num = nums[idx];
        list.add(num);
        work(idx + 1, nums, list, res);
        // 撤销选择
        list.remove(num);
    }

}
