package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution347 {


    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *  
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     *
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     */


    // 桶排序， 时间复杂度 O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // 先统计 num -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 构建一个桶，下标为次数，值为元素， 元素肯能重复，故使用一个列表
        List<Integer>[] tist = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = tist[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
                tist[entry.getValue()] = list;
            }
            list.add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        // 从尾到头遍历， 获取k个返回
        for (int i = tist.length - 1; i >= 0; i--) {
            if (idx == k) {
                break;
            }
            List<Integer> list = tist[i];
            if (list != null) {
                for (Integer value : list) {
                    res[idx++] = value;
                }
            }
        }
        return res;
    }
}
