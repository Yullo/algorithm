package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by HAOYUXING on 2020/5/28.
 */
public class Solution56 {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     */


    // 区间问题先排序，再处理
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if (intervals.length == 0) {
            return list.toArray(new int[][]{});
        }
        Arrays.sort(intervals, Comparator.comparing(item -> item[0]));
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 上一个
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            // 上一个的结尾大于新的开头
            if (last[1] >= curr[0]) {
                // 合并，结尾要找最大的
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 不包含，加到结果集
                list.add(curr);
            }
        }
        int[][] ints = new int[list.size()][2];
        return list.toArray(ints);
    }
}
