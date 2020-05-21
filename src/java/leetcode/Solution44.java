package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/5/21.
 */
public class Solution44 {

    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     *
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * 示例 3:
     *
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * 示例 4:
     *
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * 示例 5:
     *
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输入: false
     *
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     */

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1 && p.charAt(0) == '*') {
            return true;
        }

        if (s.length() > 0 && s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            // 完全匹配
            return s.length() > 0 && isMatch(s.substring(1), p.substring(1));
        }

        if (p.charAt(0) == '*') {
            // 匹配0次 或 无数次
            return isMatch(s, p.substring(1)) || s.length() > 0 && isMatch(s.substring(1), p);
        }

        return false;
    }


    // 上面的方法提交会超时，用备忘录优化重复子问题
    public boolean isMatchV2(String s, String p) {
        // i,j --> boolean  表示从 i，j 索引开始的字符串，是否匹配
        Map<String, Boolean> mem = new HashMap<>();
        return isMatch(s, p, 0, 0, mem);
    }

    private boolean isMatch(String s, String p, int i, int j, Map<String, Boolean> mem) {
        String key = buildKey(i, j);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        if (j == p.length()) {
            return i == s.length();
        }

        if (j == p.length() - 1 && p.charAt(j) == '*') {
            return true;
        }

        boolean res = false;

        if (i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            // 完全匹配
            res = i < s.length() && isMatch(s, p, i + 1, j + 1, mem);
        }

        if (p.charAt(j) == '*') {
            // 匹配0次 或 无数次
            res = isMatch(s, p, i, j + 1, mem) || i < s.length() && isMatch(s, p, i + 1, j, mem);
        }

        mem.put(key, res);
        return res;
    }

    private String buildKey(int i, int j) {
        return String.format("X%sY%s", i, j);
    }


    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.isMatchV2("aa", "aa"));
    }
}
