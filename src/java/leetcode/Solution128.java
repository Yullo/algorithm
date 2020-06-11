package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HAOYUXING on 2020/6/11.
 */
public class Solution128 {

    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     *
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     */

    public int longestConsecutive(int[] nums) {
        // 使用额外空间存储，使查找一个数的时间复杂度变成O(1)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        // 遍历
        for (int num : nums) {
            // 从最小的起点开始查找，如果不是最小起点的数，说明已经查找过了，跳过即可
            if (!set.contains(num - 1)) {
                // 计数
                int temp = 0;
                while (set.contains(num++)) {
                    temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;

    }

    /**
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
     *
     * 只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，因此数组中的每个数只会进入内层循环一次
     *
     */

}
