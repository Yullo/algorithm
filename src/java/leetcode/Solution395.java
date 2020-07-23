package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution395 {
    /**
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     *
     * 示例 1:
     *
     * 输入:
     * s = "aaabb", k = 3
     *
     * 输出:
     * 3
     *
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 示例 2:
     *
     * 输入:
     * s = "ababbc", k = 2
     *
     * 输出:
     * 5
     *
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     *
     * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
     */

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        // 计数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 个数小于k的字符一定不会出现在子串中, 以此分割成左右字串，分别判断
            if (map.get(c) < k) {
                // 连续重复的字符不需要判断
                if (i < s.length() - 1 && s.charAt(i + 1) == c) {
                    continue;
                }
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(i + 1), k));
            }

        }
        // 说明所有字符均大于等于k
        return s.length();
    }

}
