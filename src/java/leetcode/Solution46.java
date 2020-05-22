package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/5/21.
 */
public class Solution46 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/permutations
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        work(nums, new ArrayList<>(), res);
        return res;
    }

    private void work(int nums[], List<Integer> list, List<List<Integer>> res) {
        // 结束条件：nums 中的元素全都在 list 中出现
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 选择列表：nums 中不存在于 list 的那些元素
        for (Integer num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            work(nums, list, res);
            list.remove(num);
        }
    }

    /**
     * 回溯算法框架:
     *
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */
}
