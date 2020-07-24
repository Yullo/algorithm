package leetcode;

/**
 * Created by HAOYUXING on 2020/5/6.
 */
public class Solution3 {

    /**
     * 3. 无重复字符的最长子串
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     *
     * tag: 滑动窗口
     */

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            // 子串，不包含 right
            String sub = s.substring(left, right);
            // 拿到right的元素
            String charAt = s.charAt(right) + "";
            // 子串已包含
            if (sub.contains(charAt)) {
                // 右边框不动，移动左边框，缩小窗口
                left++;
            } else {
                // 字串未包含下一个元素，扩展窗口, 纳入元素
                right++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
